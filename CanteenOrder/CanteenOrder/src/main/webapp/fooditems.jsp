<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Food Menu</title>
</head>
<body>
    <h1>Food Menu</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <%
            List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
            for (FoodItem item : foodItems) {
        %>
        <tr>
            <td><%= item.getId() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %></td>
            <td><a href="OrderServlet?id=<%= item.getId() %>">Order</a></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
