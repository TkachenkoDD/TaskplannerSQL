package com.taskplannersql.servlets;

import com.taskplannersql.service.GoalService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The servlet serves to add new goals.
 */
@WebServlet("/goal")
public class GoalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("currentUser");
        req.setCharacterEncoding("UTF-8");
        String goalName = req.getParameter("goalname");
        GoalService.createGoal(goalName, user);
        resp.sendRedirect("/taskplannersql/task");
    }
}
