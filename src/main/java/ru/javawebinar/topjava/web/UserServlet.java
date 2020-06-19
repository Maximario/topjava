package ru.javawebinar.topjava.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("forward to users");
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("select".equals(action)) {
            log.info("select user");
            String paramUserId = req.getParameter("userId");
            if (paramUserId != null && !paramUserId.isEmpty()) {
                int userId = Integer.parseInt(paramUserId);
                log.info("select user id={}", userId);
                SecurityUtil.setAuthUserId(userId);
            }
            resp.sendRedirect(req.getContextPath());
        }
        else req.getRequestDispatcher("/users.jsp").forward(req, resp);

    }
}
