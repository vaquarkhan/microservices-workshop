package de.predic8.workshop.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class PurchaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);
	}
}