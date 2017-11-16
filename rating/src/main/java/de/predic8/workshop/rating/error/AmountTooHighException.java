package de.predic8.workshop.rating.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AmountTooHighException extends RuntimeException {
}
