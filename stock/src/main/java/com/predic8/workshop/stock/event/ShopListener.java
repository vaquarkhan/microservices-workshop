package com.predic8.workshop.stock.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.workshop.stock.dto.Stock;
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
	private final Map<String, Stock> articles;

	@KafkaListener(topics = "shop")
	public void listen(Operation operation) throws IOException {
		if (!operation.getType().equals("article")) {
			log.info("Unknown type: {}", operation.getType());

			return;
		}

		if (!operation.getAction().equals("create")) {
			log.error("Unknown action: {}", operation.getAction());

			return;
		}

		Stock stock = objectMapper.convertValue(operation.getObject(), Stock.class);

		articles.put(stock.getUuid(), stock);
	}
}