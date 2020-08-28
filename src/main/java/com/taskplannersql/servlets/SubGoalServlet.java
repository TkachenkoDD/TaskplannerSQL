package com.taskplannersql.servlets;

import com.taskplannersql.service.SubGoalService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet is used to add new subgoals.
 */
@WebServlet("/subgoal")
public class SubGoalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("currentUser");
        req.setCharacterEncoding("UTF-8");
        String subGoalName = req.getParameter("subgoalname");
        String idGoal = req.getParameter("idgoal");
        SubGoalService.createSubGoal(subGoalName, idGoal, user);
        resp.sendRedirect("/taskplannersql/task");
    }
}
