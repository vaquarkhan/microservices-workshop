package de.predic8.workshop.rating.rest;

import de.predic8.workshop.rating.dto.RatingRequest;
import de.predic8.workshop.rating.error.AmountTooHighException;
import de.predic8.workshop.rating.error.LimitReachedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RatingRestController {
	private final Map<String, BigDecimal> payments;

	@PostMapping("/ratings")
	public ResponseEntity<Void> rating(@RequestBody RatingRequest ratingRequest) {
		if (ratingRequest.getAmount().compareTo(new BigDecimal(1000)) > 0) {
			throw new AmountTooHighException();
		}

		BigDecimal sum = payments.getOrDefault(ratingRequest.getCustomer(), BigDecimal.ZERO)
		                         .add(ratingRequest.getAmount());

		if (sum.compareTo(new BigDecimal(3000)) > 0) {
			throw new LimitReachedException();
		}

		payments.put(ratingRequest.getCustomer(), sum);

		return ResponseEntity.ok().build();
	}
}