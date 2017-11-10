package com.predic8.workshop.stock.event;

import com.predic8.workshop.stock.domain.Article;
import com.predic8.workshop.stock.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@KafkaListener(topics = "article", containerFactory = "jsonKafkaListenerContainerFactory")
public class ArticleListener {
	private final ArticleRepository articleRepository;

	@KafkaHandler
	public void listen(@Header CreateArticle createArticle) {
		articleRepository.save(new Article());
	}
}