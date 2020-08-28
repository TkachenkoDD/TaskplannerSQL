package com.taskplannersql.servlets;

import com.taskplannersql.service.GoalService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The servlet serves for editing goals.
 */
@WebServlet("/goaledit")
public class EditGoalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String goalName = req.getParameter("editgoal");
        String newGoalName = req.getParameter("neweditgoal");
        GoalService.editGoal(goalName, newGoalName);
        resp.sendRedirect("/taskplannersql/task");
    }
}
