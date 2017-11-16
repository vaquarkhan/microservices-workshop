package de.predic8.workshop.rating.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "The amount must not exceed 1000 €.")
public class AmountTooHighException extends RuntimeException {
}
