package com.predic8.articles.event;

import lombok.Value;

@Value
public class CreateArticle {
	String name;
	String description;
}