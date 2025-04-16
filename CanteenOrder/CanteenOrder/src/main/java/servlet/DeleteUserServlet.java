package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import dao.UserDao;

public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();
        userDao.deleteUser(userId);

        response.sendRedirect("usermanagement.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();
        userDao.deleteUser(userId);

        response.sendRedirect("usermanagement.jsp");
    }
}
    