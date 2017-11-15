package de.predic8.workshop.rating.rest;

import de.predic8.workshop.rating.dto.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingRestController {
	@GetMapping("/ratings")
	public Rating rating(PaymentRequest paymentRequest) {

	}
}
