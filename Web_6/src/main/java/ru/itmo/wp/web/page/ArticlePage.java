package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ArticlePage {
    private final ArticleService articleService = new ArticleService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        // No operations.
    }

    private void create(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        Article article = new Article();
        User user = (User) request.getSession().getAttribute("user");
        article.setUserId(user.getId());
        article.setTitle(request.getParameter("title"));
        article.setText(request.getParameter("text"));
        article.setHidden(false);

        articleService.validateArticle(article);
        articleService.createArticle(article);

        request.getSession().setAttribute("message", "Article created successfully!");
        throw new RedirectException("/index");
    }

}

