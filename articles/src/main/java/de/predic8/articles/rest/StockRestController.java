package de.predic8.articles.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.predic8.articles.error.NotFoundException;
import de.predic8.articles.dto.Article;
import de.predic8.articles.event.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class StockRestController {

	private final KafkaTemplate<String, Operation> kafka;
	private final ObjectMapper mapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Article article, UriComponentsBuilder builder) {
		log.info("Creating : " + article);

		String uuid = UUID.randomUUID().toString();
		article.setId(uuid);

		kafka.send("shop", new Operation("create", "article", mapper.valueToTree(article)));

		URI location = builder
				.path("/articles/{id}")
				.buildAndExpand(uuid).toUri();

		return ResponseEntity.created(location).build();
	}
}