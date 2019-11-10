package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/** @noinspection unused*/
public class UsersPage extends Page {

    private final UserService userService = new UserService();

    public void before(HttpServletRequest request, Map<String, Object> view) {
        super.before(request, view);
    }

    private void action(Map<String, Object> view) {
        view.put("users", userService.findAll());
    }
}
