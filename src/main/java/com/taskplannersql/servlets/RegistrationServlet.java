package com.taskplannersql.servlets;

import com.taskplannersql.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The servlet serves to register a new user.
 */
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> list = UserService.checkUser();
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("newlogin");
        String password = req.getParameter("newpassword");
        if (list.contains(login)) {
            String warn1 = "Пользователь с таким именем уже существует!";
            req.setAttribute("warn1", warn1);
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            UserService.addUser(login, DigestUtils.md5Hex(password));
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}
