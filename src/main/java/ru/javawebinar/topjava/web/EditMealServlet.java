package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.MemoryMealRepository;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class EditMealServlet extends HttpServlet {

    private static final MealRepository repository = MemoryMealRepository.getInstance();
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !"".equals(id)) {
            int mealId = Integer.parseInt(id);
            if ("delete".equals(req.getParameter("action"))) {
                log.debug("delete meal, id = " + mealId);
                repository.delete(mealId);
                resp.sendRedirect("meals");
            } else {
                log.debug("get Meal, id = " + mealId);
                Meal result = repository.get(mealId);
                req.setAttribute("meal", result);
                req.getRequestDispatcher("meal.jsp").forward(req, resp);
            }
        } else {
            log.debug("create new meal");
            req.getRequestDispatcher("meal.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Post meal");
        String id = req.getParameter("id");
        String dateTime = req.getParameter("dateTime");
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");
        Meal meal = new Meal(LocalDateTime.parse(dateTime), description, Integer.parseInt(calories));
        if (id != null && !id.equals("")) {
            log.debug("Update meal, id = " + id);
            meal.setId(Integer.parseInt(id));
            repository.update(meal);
        } else {
            log.debug("Create new meal");
            repository.create(meal);
        }
        resp.sendRedirect("meals");
    }
}
