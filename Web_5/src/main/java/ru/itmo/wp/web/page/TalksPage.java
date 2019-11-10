package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.service.TalkService;
import ru.itmo.wp.model.service.UserService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TalksPage extends Page {
    private final UserService userService = new UserService();
    private final TalkService talkService = new TalkService();

    public void before(HttpServletRequest request, Map<String, Object> view) {
        super.before(request, view);
        if (!view.containsKey("user")) {
            setMessage(request, view, "You are not authorised");
            throw new RedirectException("/index");
        }
        view.put("users", userService.findAll());
        view.put("talks", talkService.findTalksByUserId(getUser(request, view).getId()));

    }

    private void action(Map<String, Object> view) {

    }

    private void send(Map<String, Object> view, HttpServletRequest request) {
        User targetUser = userService.findById(Long.parseLong(request.getParameter("targetUserId")));
        if (targetUser == null) {
            setMessage(request, view, "No such user");
            throw new RedirectException("/talks");
        }
        User sourceUser = getUser(request, view);
        Talk talk = new Talk();
        talk.setSourceUserId(sourceUser.getId());
        talk.setTargetUserId(Long.parseLong(request.getParameter("targetUserId")));
        talk.setText(request.getParameter("text"));

        talkService.createTalk(talk);
        throw new RedirectException("/talks");
    }
}
