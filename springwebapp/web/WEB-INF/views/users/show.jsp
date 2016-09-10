<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 8/9/16
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.username}'s Profile</title>
</head>
<body>
    <div id="user">
        <ul>
            <li>${user.username}</li>
            <li>${user.email}</li>
        </ul>
    </div>
</body>
</html>
