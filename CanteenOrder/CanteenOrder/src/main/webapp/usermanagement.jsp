<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>Manage Users</h1>
    <form action="UserServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select><br><br>

        <input type="submit" value="Create User">
    </form>

    <h2>Existing Users</h2>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td><%= user.getUsername() %></td>
            <td><%= user.getRole() %></td>
            <td><a href="DeleteUserServlet?id=<%= user.getId() %>">Delete</a></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
