package com.predic8.workshop.history.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.workshop.history.dto.Payment;
import com.predic8.workshop.history.dto.PaymentRequest;
import com.predic8.workshop.history.event.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/payments")
@RestController
public class PaymentsRestController {
	private final ObjectMapper objectMapper;
	private final Map<String, Payment> payments;
	private final RestTemplate restTemplate;
	private final KafkaTemplate<String, Operation> kafkaTemplate;

	@GetMapping("/{uuid}")
	public Payment index(@PathVariable String uuid) {
		return payments.get(uuid);
	}

	@PostMapping("/{uuid}")
	public ResponseEntity<?> save(@PathVariable String uuid, @RequestBody PaymentRequest paymentRequest) {
		restTemplate.postForEntity("http://localhost:8083/ratings/{uuid}", paymentRequest, Void.class, uuid);

		kafkaTemplate.send("shop", new Operation("create", "payment", objectMapper.valueToTree(paymentRequest)));

		return ResponseEntity.accepted().build();
	}
}