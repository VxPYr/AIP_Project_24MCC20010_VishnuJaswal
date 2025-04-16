package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;
import dao.OrderDao;
import model.Order;
import model.User;

public class OrderListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Long userId = user.getId();  // Ensure the userId is Long, not int

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getOrdersByUser(userId);  // Pass Long to DAO

        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderlist.jsp");
        dispatcher.forward(request, response);
    }
}
