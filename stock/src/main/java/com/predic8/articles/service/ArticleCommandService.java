package com.predic8.articles.service;

import com.predic8.articles.domain.Article;
import com.predic8.articles.event.CreateArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleCommandService {
	private final KafkaTemplate<String, CreateArticle> kafkaTemplate;

	public void save(String uuid, Article article) {
		kafkaTemplate.send("article", uuid, new CreateArticle(article.getName(), article.getDescription(), article.getPrice()));
	}
}