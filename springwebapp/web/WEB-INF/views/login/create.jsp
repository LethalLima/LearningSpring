<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 6/30/16
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
    <title>Create Account</title>
</head>
<body>
<h3>Create New Account</h3>

<sf:form name="f" action="/login/create" method="POST" modelAttribute="user">
    <table class="table-form">
        <tr>
            <td>Username:</td>
            <td><sf:input type="text" name="username" value="" path="username"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><sf:input type="text" name="email" value="" path="email"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><sf:input type="password" name="password" path="password"/></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirmPassword"/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Create Account"></td>
        </tr>
    </table>
</sf:form>
</body>
</html>