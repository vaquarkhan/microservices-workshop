package com.predic8.workshop.stock.dto;

public class Article {
	private final String uuid;
    private final long stock;

	public Article(String uuid, long stock) {
		this.uuid = uuid;
		this.stock = stock;
	}

	public String getUuid() {
		return uuid;
	}

	public long getStock() {
		return stock;
	}
}