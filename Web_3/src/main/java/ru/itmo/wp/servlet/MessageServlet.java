package ru.itmo.wp.servlet;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class MessageServlet extends HttpServlet {

    private class userMessage {
        String user;
        String text;

        userMessage(String user, String text) {
            this.user = user;
            this.text = text;
        }
    }
    private ArrayList<userMessage> messages = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        response.setCharacterEncoding("windows-1251");
        if (uri.endsWith("auth")) {
            String user = request.getParameter("user");
            HttpSession httpSession = request.getSession();
            if (user != null) {
                httpSession.setAttribute("user", user);
            } else {
                user = (String) httpSession.getAttribute("user");
            }

            String json = new Gson().toJson(user);
            response.getWriter().print(json);
            response.getWriter().flush();
        } else if (uri.endsWith("add")) {
            String text = request.getParameter("text");
            messages.add(new userMessage((String) request.getSession().getAttribute("user"), text));
        } else if (uri.endsWith("findAll")) {
            String json = new Gson().toJson(messages);
            response.getWriter().print(json);
            response.getWriter().flush();
        }
        response.setContentType("application/json");
    }
}

