package de.predi8.workshop.catalogue.rest;

import de.predi8.workshop.catalogue.dto.Article;
import de.predi8.workshop.catalogue.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CatalogueRestController {
    private final Map<String, Article> articles;

    @RequestMapping("/articles")
    @GetMapping
    public Collection<Article> index() {
        return articles.values();
    }

    @RequestMapping("/articles/{id}")
    @GetMapping
    public Article get(@PathVariable String id) {

        Article article = articles.get(id);

        if (article == null) {
            throw new NotFoundException();
        }

        return article;
    }
}