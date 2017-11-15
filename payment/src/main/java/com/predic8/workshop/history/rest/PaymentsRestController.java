package com.predic8.workshop.history.rest;

import com.predic8.workshop.history.dto.Payment;
import com.predic8.workshop.history.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/payments")
@RestController
public class PaymentsRestController {
	private final Map<String, Payment> payments;

	@GetMapping("/{uuid}")
	public Payment index(@PathVariable String uuid) {
		return payments.get(uuid);
	}

	@PostMapping
	public ResponseEntity<?> save(PaymentRequest paymentRequest) {
		return null;
	}
}