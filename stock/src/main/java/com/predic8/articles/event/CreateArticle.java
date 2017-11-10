package com.predic8.articles.event;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateArticle implements Event {
	String name;
	String description;
	BigDecimal price;
}