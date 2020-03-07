package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersPage extends Page {
    private final UserService userService;

    public UsersPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }

    @PostMapping("/users/change/{id:\\d{1,18}}")
    public String changeDisabled(@PathVariable("id")  long id, HttpSession httpSession) {
        User user = userService.findById(id);
        if (user == null) {
            putMessage(httpSession, "No such user id");
        } else {
            user.setDisabled(!user.isDisabled());
            userService.updateDisable(user);
        }
        return "redirect:/users/all";
    }
//    @PostMapping("/users/all")
//    public String disableUser()
}
