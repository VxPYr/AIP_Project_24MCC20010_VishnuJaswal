package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import model.User;
import dao.UserDao;

public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String role = request.getParameter("role");

        User user = new User(username, role);
        UserDao userDao = new UserDao();
        userDao.createUser(user);

        response.sendRedirect("usermanagement.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("usermanagement.jsp");
    }
}
