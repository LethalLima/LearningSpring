<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 5/30/16
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/test">Offers</a>
    <%--<p>Session: <%= session.getAttribute("name") %> </p>--%>
    <%--<p>Request:  <%= request.getAttribute("name") %> </p>--%>
    <%--<p>Request using EL: ${name}</p>--%>
    <p>Request using JSTL:<c:out value="${name}"></c:out></p>
    <%--<sql:query var="rs" dataSource="jdbc/spring">--%>
        <%--select id, firstName, lastName, email, message from offers--%>
    <%--</sql:query>--%>

    <h2>Offers</h2>

    <c:forEach var="offer" items="${offers}">
        Name: ${offer.firstName} ${offer.lastName}<br/>
        Email: ${offer.email}<br/>
        Message: ${offer.message}<br/>
        <br/>
    </c:forEach>

</body>
</html>
