package ru.itmo.wp.model.repository;

import ru.itmo.wp.model.domain.Article;

import java.util.List;

public interface ArticleRepository {
    void save(Article article);
    void changeHidden(long articleId);
    List<Article> findAll();
    Article find(long id);
}
