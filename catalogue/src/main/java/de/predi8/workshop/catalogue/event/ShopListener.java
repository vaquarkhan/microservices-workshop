package de.predi8.workshop.catalogue.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.predi8.workshop.catalogue.dto.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopListener {
	private final ObjectMapper objectMapper;
	private final List<Article> articles;

	@KafkaListener(topics = "shop")
	public void listen(Operation operation) throws IOException {
		switch (operation.getType()) {
			case "article":
				articles.add(objectMapper.convertValue(operation.getObject(), Article.class));
				return;
			default:
				log.info("Unknown type: {}", operation.getType());
		}
	}
}