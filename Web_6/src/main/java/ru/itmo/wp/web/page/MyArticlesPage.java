package ru.itmo.wp.web.page;

import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MyArticlesPage {

    private final ArticleService articleService = new ArticleService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        view.put("articles", articleService.findAll());
        view.put("user", request.getSession().getAttribute("user"));
    }

    private void changeHidden(HttpServletRequest request, Map<String, Object> view) {
        articleService.changeHidden(Long.parseLong(request.getParameter("articleId")));
        throw new RedirectException("/myArticles");
    }
}
