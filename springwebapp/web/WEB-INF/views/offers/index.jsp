<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 5/30/16
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Offers</title>
</head>
<body>
    <h2>Offers</h2>
    <p><a href="/offers/create">Add New Offer</a></p>
    <c:forEach var="offer" items="${offers}">
        <%--Name: ${offer.firstName} ${offer.lastName}<br/>--%>
        <%--Email: ${offer.email}<br/>--%>
        <%--Message: ${offer.message}<br/>--%>
        <%--<br/>--%>

        <%-- toString in Offer class--%>
        <p><c:out value="${offer}"></c:out></p>
    </c:forEach>

</body>
</html>
