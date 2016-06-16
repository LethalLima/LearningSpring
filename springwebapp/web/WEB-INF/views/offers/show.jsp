<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 6/13/16
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offer</title>
</head>
<body>
    <h2>Offer</h2>
    <table>
        <tr>
            <td class="label">${offer.firstName} ${offer.lastName}</td>
        </tr>
        <tr>
            <td class="label">${offer.email}</td>
        </tr>
        <tr>
            <td>${offer.message}</td>
        </tr>
        <tr>
            <td><a href="/offers/${offer.id}/edit">Edit Offer</a></td>
        </tr>
    </table>
</body>
</html>
