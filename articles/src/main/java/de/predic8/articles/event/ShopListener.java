package de.predic8.articles.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.predic8.articles.dto.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopListener {
	private final KafkaTemplate<String, Operation> kafka;
	private final ObjectMapper mapper;

	private final Map<String, Article> articles;

	@KafkaListener(id = "articles-listener",
			topicPartitions =
					{ @TopicPartition(topic = "shop",
							partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))})
	public void listen(Operation operation) throws IOException {

		log.info("Got Message: " + operation);

		if(!operation.getType().equals("article"))
			return;

		Article article = mapper.convertValue(operation.getObject(), Article.class);

		switch (operation.getAction()) {
			case "create":
			case "update":
				articles.put(article.getId(), article);
				break;
		}

	}
}