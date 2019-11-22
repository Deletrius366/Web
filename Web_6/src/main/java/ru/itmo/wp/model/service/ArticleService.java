package ru.itmo.wp.model.service;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.ArticleRepository;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepositoryImpl();

    public void createArticle(Article article) {
        articleRepository.save(article);
    }
    public List<Article> findAll() {return articleRepository.findAll();}
    public Article find(long id) {return articleRepository.find(id);}
    public void changeHidden(long articleId) {articleRepository.changeHidden(articleId);}

    public void validateArticle(Article article) throws ValidationException {
        if (Strings.isNullOrEmpty(article.getTitle())) {
            throw new ValidationException("Title required");
        }

        if (Strings.isNullOrEmpty(article.getText())) {
            throw new ValidationException("Text required");
        }
    }
}
