package com.taskplannersql.servlets;

import com.taskplannersql.service.SubGoalService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The servlet serves to remove the subgoal.
 */
@WebServlet("/subgoaldelete")
public class SubGoalDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String subGoalName = req.getParameter("deletesubgoal");
        SubGoalService.deleteSubGoal(subGoalName);
        resp.sendRedirect("/taskplannersql/task");
    }
}