package com.taskplannersql.servlets;

import com.taskplannersql.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The servlet serves to authorize the user,
 * session assignments for an authorized user and
 * closing session.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String user = req.getParameter("login");
        String password = req.getParameter("password");
        ArrayList<String> presentUsers = UserService.checkUser();
        String checkedPassword = UserService.checkPassword(user);
        if ((presentUsers.contains(user)) && (checkedPassword.equals(DigestUtils.md5Hex(password)))) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            session.setMaxInactiveInterval(-1);
            resp.sendRedirect("/taskplannersql/task");
        } else {
            String warn = "Неверный логин или пароль!";
            req.setAttribute("warn", warn);
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/taskplannersql");
    }
}