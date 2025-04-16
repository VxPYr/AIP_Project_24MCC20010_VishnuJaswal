<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Place Order</title>
</head>
<body>
    <h1>Place Order</h1>
    <form action="OrderServlet" method="post">
        <label for="foodItemId">Food Item ID:</label>
        <input type="text" id="foodItemId" name="foodItemId" required><br><br>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br><br>

        <input type="submit" value="Place Order">
    </form>
</body>
</html>
