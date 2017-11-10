package com.predic8.articles.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Article {
	@Id
	private String uuid;
	private String name;
	private String description;
	private BigDecimal price;
	private long stock = 0;
}