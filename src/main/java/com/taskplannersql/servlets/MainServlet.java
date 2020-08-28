package com.taskplannersql.servlets;

import com.taskplannersql.beans.Goal;
import com.taskplannersql.beans.SubGoal;
import com.taskplannersql.service.GoalService;
import com.taskplannersql.service.SubGoalService;
import com.taskplannersql.service.TaskService;
import com.taskplannersql.beans.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The servlet serves to transfer all tasks and goals to the main page mainPage.jsp
 * and to add new tasks.
 */
@WebServlet("/task")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("currentUser");
        ArrayList<Goal> goals = GoalService.readGoals(user);
        req.setAttribute("goals", goals);
        ArrayList<SubGoal> subGoals = SubGoalService.readSubGoals(user);
        req.setAttribute("subgoals", subGoals);
        ArrayList<Task> tasks = TaskService.readAllTasks(user);
        if (tasks.isEmpty()) {
            String text = "Задач пока нет!";
            req.setAttribute("text", text);
        } else {
            req.setAttribute("tasks", tasks);
        }
        getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("currentUser");
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("task");
        String description = req.getParameter("description");
        String dateOfEnd = req.getParameter("dateofend");
        String idOfGoal = req.getParameter("idofgoal");
        String idOfSubGoal = req.getParameter("idofsubgoal");
        TaskService.createTask(text, description, dateOfEnd, idOfGoal, idOfSubGoal, user);
        resp.sendRedirect("/taskplannersql/task");
    }
}
