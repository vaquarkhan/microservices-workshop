package com.predic8.workshop.stock.repository;

import com.predic8.workshop.stock.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
