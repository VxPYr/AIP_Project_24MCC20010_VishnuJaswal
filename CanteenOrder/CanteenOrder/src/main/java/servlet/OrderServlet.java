package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import dao.OrderDao;
import model.Order;
import model.FoodItem;
import model.User;

public class OrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the foodItemId and quantity from the request parameters
        int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Assume that we get the FoodItem from the database (simplified)
        FoodItem foodItem = new FoodItem(foodItemId, "Food Item Name", 50.0); // Simplified, normally retrieved from the DB

        // Create an order using the FoodItem and quantity
        Order order = new Order(foodItem, quantity);

        // Save the order in the database via the DAO
        OrderDao orderDao = new OrderDao();
        orderDao.placeOrder(order);

        // Set the order in the session (if needed)
        HttpSession session = request.getSession();
        session.setAttribute("order", order);

        // Redirect to the order list page
        response.sendRedirect("orderlist.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request (if needed)
    }
}
