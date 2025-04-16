<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Something went wrong!</h1>
    <p>Error details: <%= request.getAttribute("errorMessage") %></p>
</body>
</html>
