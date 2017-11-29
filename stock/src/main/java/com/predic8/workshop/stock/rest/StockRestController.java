package com.predic8.workshop.stock.rest;

import com.predic8.workshop.stock.dto.Stock;
import com.predic8.workshop.stock.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/stocks")
@RestController
public class StockRestController {

	private final Map<String, Stock> articles;

	@GetMapping("/{uuid}")
	public Stock show(@PathVariable String uuid) {

		log.info("get Stock for UUID: " , uuid);

		Stock stock = articles.get(uuid);

		if (stock == null) {
			throw new NotFoundException();
		}

		return stock;
	}
}