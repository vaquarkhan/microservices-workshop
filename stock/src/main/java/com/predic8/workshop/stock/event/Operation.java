package com.predic8.workshop.stock.event;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class Operation {
	private String action;
	private String type;
	private JsonNode object;
}