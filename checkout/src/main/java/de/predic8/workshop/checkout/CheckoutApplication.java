package de.predic8.workshop.checkout;

import de.predic8.workshop.checkout.dto.Basket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class CheckoutApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Map<String, Basket> baskets() {
		return new ConcurrentHashMap<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}
}