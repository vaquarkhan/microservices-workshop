package com.predic8.workshop.stock.rest;

import com.predic8.workshop.stock.dto.Stock;
import com.predic8.workshop.stock.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/stocks")
@RestController
public class StockRestController {
	private final Map<String, Stock> articles;

	@GetMapping("/{uuid}")
	public Stock show(@PathVariable String uuid) {
		Stock stock = articles.get(uuid);

		if (stock == null) {
			throw new NotFoundException();
		}

		return stock;
	}
}