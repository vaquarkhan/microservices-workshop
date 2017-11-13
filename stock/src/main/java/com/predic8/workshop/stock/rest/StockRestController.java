package com.predic8.workshop.stock.rest;

import com.predic8.workshop.stock.dto.Article;
import com.predic8.workshop.stock.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/stock")
@RestController
public class StockRestController {
	private final Map<String, Article> stock;

	@GetMapping("/{uuid}")
	public Article show(@PathVariable String uuid) {
		Article article = this.stock.get(uuid);

		if (article == null) {
			throw new NotFoundException();
		}

		return article;
	}
}