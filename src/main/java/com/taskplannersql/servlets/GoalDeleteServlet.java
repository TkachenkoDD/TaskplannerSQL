package com.taskplannersql.servlets;

import com.taskplannersql.service.GoalService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The servlet serves to delete the goal.
 */
@WebServlet("/goaldel")
public class GoalDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String goalName = req.getParameter("goalname");
        GoalService.deleteGoal(goalName);
        resp.sendRedirect("/taskplannersql/task");
    }
}
