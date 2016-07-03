<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 6/15/16
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="/resources/css/offers.css" type="text/css">
    <title>Login Page</title>
</head>
<body>
<h3>Login with Username and Password</h3>
<c:if test="${param.error != null}">
    <p class="error">Login failed. Check username and password are correct.</p>
</c:if>

<sf:form name="f" action="/login" method="POST">
    <table class="table-form">
        <tbody>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" value=""></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Login"></td>
        </tr>
        </tbody>
    </table>
</sf:form>
<p><a href="/login/create">Create Account</a></p>
</body>
</html>
