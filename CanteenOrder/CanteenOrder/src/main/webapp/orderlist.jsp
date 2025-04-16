<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
</head>
<body>
    <h1>Your Orders</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Food Item</th>
            <th>Quantity</th>
            <th>Status</th>
        </tr>
        <%
            List<Order> orders = (List<Order>) request.getAttribute("orders");
            for (Order order : orders) {
        %>
        <tr>
            <td><%= order.getId() %></td>
            <td><%= order.getFoodItem().getName() %></td>
            <td><%= order.getQuantity() %></td>
            <td><%= order.getStatus() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
