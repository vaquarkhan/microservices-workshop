package com.predic8.workshop.stock.event;

import com.predic8.workshop.stock.domain.Article;
import com.predic8.workshop.stock.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_MESSAGE_KEY;

@RequiredArgsConstructor
@Service
@KafkaListener(topics = "stock")
public class ArticleListener {
	private final ArticleRepository articleRepository;

	@KafkaHandler
	public void listen(@Header(RECEIVED_MESSAGE_KEY) String key, CreateArticle createArticle) {
		articleRepository.save(new Article(key, createArticle.getName(), createArticle.getDescription(), createArticle.getPrice(), 0));
	}
}