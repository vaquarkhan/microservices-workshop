package com.predic8.workshop.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ArticlesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArticlesApplication.class, args);
	}
}
