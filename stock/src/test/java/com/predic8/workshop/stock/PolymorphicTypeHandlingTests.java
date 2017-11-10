package com.predic8.workshop.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.workshop.stock.event.CreateArticle;
import com.predic8.workshop.stock.event.Event;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PolymorphicTypeHandlingTests {
	@Test
	public void shouldWrapTheSerializedEvent() throws JsonProcessingException, JSONException {
		String createArticle = new ObjectMapper().writeValueAsString(
			new CreateArticle(
				"Cloud Native Java",
				"Designing Resilient Systems with Spring Boot, Spring Cloud, and Cloud Foundry",
				new BigDecimal("39.99")
			)
		);

		JSONAssert.assertEquals("{\"createArticle\":{\"name\":\"Cloud Native Java\",\"description\":\"Designing Resilient Systems with Spring Boot, Spring Cloud, and Cloud Foundry\",\"price\":39.99}}", createArticle, false);
	}

	@Test
	public void shouldDeserializeTheEventIntoTheCorrectSubtype() throws IOException, JSONException {
		Event event = new ObjectMapper().readValue("{\"createArticle\":{\"name\":\"Cloud Native Java\",\"description\":\"Designing Resilient Systems with Spring Boot, Spring Cloud, and Cloud Foundry\",\"price\":39.99}}", Event.class);

		assertThat(event).isInstanceOf(CreateArticle.class);
	}
}