package de.predic8.workshop.checkout.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.predic8.workshop.checkout.dto.Basket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class BasketListener {
	private final ObjectMapper objectMapper;
	private final Map<String, Basket> baskets;

	@KafkaListener(topics = "shop")
	public void listen(Operation operation) {
		if (!operation.getType().equals("basket")) {
			log.info("Unknown type: {}", operation.getType());

			return;
		}

		Basket basket = objectMapper.convertValue(operation.getObject(), Basket.class);

		baskets.put(basket.getUuid(), basket);
	}
}