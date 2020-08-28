package com.taskplannersql.servlets;

import com.taskplannersql.service.TaskService;
import com.taskplannersql.beans.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet is used to search for tasks by ID.
 */
@WebServlet("/readid")
public class ReadTaskIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Task task = TaskService.read(id);
        if (task != null) {
            req.setAttribute("task", task);
            getServletContext().getRequestDispatcher("/task").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }
    }
}