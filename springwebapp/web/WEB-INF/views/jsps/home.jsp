<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 5/30/16
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/test">Offers</a>
    <%--<p>Session: <%= session.getAttribute("name") %> </p>--%>
    <%--<p>Request:  <%= request.getAttribute("name") %> </p>--%>
    <p>Request using EL: ${name}</p>
</body>
</html>
