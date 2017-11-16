package de.predic8.workshop.rating.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "The maximum limit of 3000 € has been reached.")
public class LimitReachedException extends RuntimeException {
}