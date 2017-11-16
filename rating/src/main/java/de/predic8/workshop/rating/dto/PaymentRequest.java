package de.predic8.workshop.rating.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PaymentRequest {
	String customerId;
	BigDecimal amount;
}