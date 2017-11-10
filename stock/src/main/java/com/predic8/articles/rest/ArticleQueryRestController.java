package com.predic8.articles.rest;

import com.predic8.articles.domain.Article;
import com.predic8.articles.error.NotFoundException;
import com.predic8.articles.service.ArticleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class ArticleQueryRestController {
	private final ArticleQueryService articleQueryService;

	@GetMapping
	public List<Article> index() {
		return articleQueryService.index();
	}

	@GetMapping("/{uuid}")
	public Article show(@PathVariable String uuid) {
		return articleQueryService.show(uuid).orElseThrow(NotFoundException::new);
	}
}