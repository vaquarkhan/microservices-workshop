package de.predic8.workshop.rating.rest;

import de.predic8.workshop.rating.dto.PaymentRequest;
import de.predic8.workshop.rating.error.AmountTooHighException;
import de.predic8.workshop.rating.error.LimitReachedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RatingRestController {
	private final Map<String, BigDecimal> payments;

	@PostMapping("/ratings")
	public ResponseEntity<Void> rating(PaymentRequest paymentRequest) {
		if (paymentRequest.getAmount().compareTo(new BigDecimal(1000)) > 0) {
			throw new AmountTooHighException();
		}

		BigDecimal sum = payments.getOrDefault(paymentRequest.getCustomerId(), BigDecimal.ZERO)
		                         .add(paymentRequest.getAmount());

		if (sum.compareTo(new BigDecimal(3000)) > 0) {
			throw new LimitReachedException();
		}

		payments.put(paymentRequest.getCustomerId(), sum);

		return ResponseEntity.ok()
		                     .build();
	}
}