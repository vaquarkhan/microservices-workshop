package com.predic8.workshop.stock.service;

import com.predic8.workshop.stock.domain.Article;
import com.predic8.workshop.stock.event.CreateArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleCommandService {
	private final KafkaTemplate<String, CreateArticle> kafkaTemplate;

	public void save(String uuid, Article article) {
		kafkaTemplate.send("stock", uuid, new CreateArticle(article.getName(), article.getDescription(), article.getPrice()));
	}
}