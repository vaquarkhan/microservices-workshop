package com.predic8.workshop.stock.rest;

import com.predic8.workshop.stock.domain.Article;
import com.predic8.workshop.stock.service.ArticleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/stock")
@RestController
public class StockQueryRestController {
	private final ArticleQueryService articleQueryService;

	@GetMapping
	public Page<Article> index(Pageable pageable) {
		return articleQueryService.index(pageable);
	}
}