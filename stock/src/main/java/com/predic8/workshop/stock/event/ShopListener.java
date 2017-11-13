package com.predic8.workshop.stock.event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.workshop.stock.dto.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopListener {
	private final ObjectMapper objectMapper;
	private final Map<String, Article> articles;

	@KafkaListener(topics = "shop")
	public void listen(String payload) throws IOException {
		JsonNode event = objectMapper.readTree(payload);

		if (!event.get("type").asText().equals("article")) {
			log.info("Unknown type: {}", event.get("type").asText());

			return;
		}

		if (!event.get("action").asText().equals("create")) {
			log.error("Unknown action: {}", event.get("action").asText());

			return;
		}

		JsonNode object = event.get("object");

		articles.put(object.get("uuid").asText(), objectMapper.readValue(object.asText(), Article.class));
	}
}