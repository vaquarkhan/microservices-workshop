package com.predic8.workshop.stock;

import com.predic8.workshop.stock.dto.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableKafka
@SpringBootApplication
public class StockApplication {
	@Bean
	public Map<String, Article> articles() {
		return new ConcurrentHashMap<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
}