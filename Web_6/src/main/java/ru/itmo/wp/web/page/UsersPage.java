package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/** @noinspection unused*/
public class UsersPage {
    private final UserService userService = new UserService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        // No operations.
    }

    private void findAll(HttpServletRequest request, Map<String, Object> view) {
        view.put("users", userService.findAll());
        User user = (User) request.getSession().getAttribute("user");
        view.put("admin", (user != null) && user.isAdmin());
    }

    private void findUser(HttpServletRequest request, Map<String, Object> view) {
        view.put("user",
                userService.find(Long.parseLong(request.getParameter("userId"))));
    }

    private void changeAdmin(HttpServletRequest request, Map<String, Object> view) {
        try {
            User user = userService.find(Long.parseLong(request.getParameter("id")));
        } catch (Exception e) {
            view.put("error", true);
            view.put("message", "Invalid user id");
            throw new RedirectException("/users");
        }
        userService.changeAdmin(Long.parseLong(request.getParameter("id")));
        throw new RedirectException("/users");
    }
}
