package com.predic8.workshop.history.dto;

import lombok.Value;

import java.math.BigDecimal;

import static com.predic8.workshop.history.dto.PaymentRequest.Method.CC;

@Value
public class PaymentRequest {
	Method method = CC;
	BigDecimal amount;
	String customerId;

	enum Method {
		CC,
		PAYPAL
	}
}