package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
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
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new RedirectException("/enter");
        }
        try {
            Long articleId = Long.parseLong(request.getParameter("articleId"));
            Article article = articleService.find(articleId);
            if (user.getId() == article.getUserId()) {
                articleService.changeHidden(article.getId());
            } else {
                view.put("error", true);
                view.put("message", "You have no access to this article");
            }
        } catch (Exception ignored) {
            view.put("error", true);
            view.put("message", "Invalid article id");
        }
        throw new RedirectException("/myArticles");
    }
}
