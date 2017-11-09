package com.predic8.articles.service;

import com.predic8.articles.domain.Article;
import com.predic8.articles.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleQueryService {
	private final ArticleRepository articleRepository;

	public List<Article> index() {
		return articleRepository.findAll();
	}

	public Optional<Article> show(String uuid) {
		return Optional.ofNullable(articleRepository.findOne(uuid));
	}
}