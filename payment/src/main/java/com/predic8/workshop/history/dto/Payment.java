package com.predic8.workshop.history.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Payment {
	private BigDecimal amount;
}