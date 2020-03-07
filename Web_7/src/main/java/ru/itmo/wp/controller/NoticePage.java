package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.form.NoticeCredentials;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.NoticeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class NoticePage extends Page {
    private final NoticeService noticeService;

    public NoticePage(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String getNotice(Model model, HttpSession httpSession) {
        if (model.getAttribute("user") == null) {
            putMessage(httpSession, "You are not authorised");
            return "redirect:/";
        }
        model.addAttribute("noticeCredential", new NoticeCredentials());
        return "NoticePage";
    }

    @PostMapping("/notice")
    public String addNotice(@Valid @ModelAttribute("noticeForm") NoticeCredentials noticeForm,
                            BindingResult bindingResult,
                            HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "NoticePage";
        }

        noticeService.add(noticeForm);
        putMessage(httpSession, "Congrats, notice have been added!");

        return "redirect:/";
    }

}
