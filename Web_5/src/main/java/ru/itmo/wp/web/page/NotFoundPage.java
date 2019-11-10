package ru.itmo.wp.web.page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/** @noinspection unused*/
public class NotFoundPage extends Page {

    public void before(HttpServletRequest request, Map<String, Object> view) {
        super.before(request, view);
    }

    private void action() {
        // No operations.
    }
}
