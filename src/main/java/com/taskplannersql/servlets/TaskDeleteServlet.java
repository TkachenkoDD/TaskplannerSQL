package com.taskplannersql.servlets;

import com.taskplannersql.service.TaskService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet is used to delete a task.
 */
@WebServlet("/taskdel")
public class TaskDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaskService.deleteTask(id);
        resp.sendRedirect("/taskplannersql/task");
    }
}
