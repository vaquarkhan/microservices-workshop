package com.predic8.workshop.stock.rest;

import com.predic8.workshop.stock.domain.Article;
import com.predic8.workshop.stock.service.ArticleCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@RequestMapping("/articles")
@RestController
public class ArticleCommandRestController {
	private final ArticleCommandService articleCommandService;

	@PostMapping("/{uuid}")
	public ResponseEntity<Void> save(@PathVariable String uuid, @RequestBody Article article, UriComponentsBuilder uriComponentsBuilder) {
		articleCommandService.save(uuid, article);

		return ResponseEntity
			.accepted()
			.header("Location", uriComponentsBuilder.buildAndExpand(uuid).toUriString())
			.build();
	}
}