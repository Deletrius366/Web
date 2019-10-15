package ru.itmo.wp.servlet;

import ru.itmo.wp.util.ImageUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class CaptchaFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getSession().getAttribute("acceptedCaptcha") == null) {
            if (request.getMethod().equals("GET")) {
                String captchaNumber = Integer.toString((int) (Math.random() * 899 + 100));
                makeCaptcha(request, response, captchaNumber);
            } else {
                String enteredCaptcha = request.getParameter("captcha");
                String serverCaptcha = (String) request.getSession().getAttribute("serverCaptcha");
                if (enteredCaptcha != null)
                    System.out.println("entered captcha: " + enteredCaptcha);
                if (serverCaptcha != null)
                    System.out.println("server captcha: " + serverCaptcha);
                if (enteredCaptcha.equals(serverCaptcha)) {
                    request.getSession().setAttribute("acceptedCaptcha", "true");
                    response.sendRedirect(request.getRequestURI());
                } else {
                    makeCaptcha(request, response, Integer.toString((int) (Math.random() * 899 + 100)));
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private void makeCaptcha(HttpServletRequest request, HttpServletResponse response, String captchaNumber) throws IOException {
        request.getSession().setAttribute("serverCaptcha", captchaNumber);
        String htmlFile = new String(Files.readAllBytes(Paths.get(getServletContext().getRealPath("/static/captcha.html"))));
        String image = Base64.getEncoder().encodeToString(ImageUtils.toPng(captchaNumber));
        response.getWriter().print(String.format(htmlFile, image));
        response.getWriter().flush();
    }
}
