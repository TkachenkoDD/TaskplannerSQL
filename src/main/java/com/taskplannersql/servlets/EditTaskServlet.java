package com.taskplannersql.servlets;

import com.taskplannersql.service.TaskService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The servlet serves to edit the task.
 */
@WebServlet("/taskedit")
public class EditTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("editid"));
        String text = req.getParameter("edittext");
        String description = req.getParameter("editdescript");
        String dateOfEnd = req.getParameter("editdate");
        boolean isDone = Boolean.parseBoolean(req.getParameter("editisdone"));
        TaskService.edit(id, text, description, dateOfEnd, isDone);
        resp.sendRedirect("/taskplannersql/task");
    }
}
