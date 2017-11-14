package com.predic8.workshop.history.rest;

import com.predic8.workshop.history.dto.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/payments")
@RestController
public class PaymentsRestController {
	private final Map<String, List<Payment>> payments;

	@GetMapping("/{uuid}")
	public List<Payment> index(@PathVariable String uuid) {
		return payments.get(uuid);
	}
}