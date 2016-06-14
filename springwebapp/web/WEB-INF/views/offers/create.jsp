<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 6/12/16
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/offers.css" type="text/css">
    <title>Create Offer</title>
</head>
<body>
    <sf:form class="table-form" method="post" action="${pageContext.request.contextPath}/offers/store" modelAttribute="offer">
    <table>
        <tr>
            <td class="label">First Name: </td>
            <td>
                <sf:input class="control" path="firstName" name="firstName" type="text"></sf:input>
                <br/>
                <sf:errors path="firstName" cssClass="errors"></sf:errors>
            </td>
        </tr>
        <tr>
            <td class="label">Last Name: </td>
            <td>
                <sf:input class="control" path="lastName" name="lastName" type="text"></sf:input>
                <br/>
                <sf:errors path="lastName" cssClass="errors"></sf:errors>
            </td>
        </tr>
        <tr>
            <td class="label">Your Email: </td>
            <td>
                <sf:input class="control" path="email" name="email" type="text"></sf:input>
                <br/>
                <sf:errors path="email" cssClass="errors"></sf:errors>
            </td>
        </tr>
        <tr>
            <td class="label">Your Offer Message: </td>
            <td>
                <sf:textarea rows="10" cols="10" class="control" path="message" name="message"></sf:textarea>
                <br/>
                <sf:errors path="message" cssClass="errors"></sf:errors>
            </td>
        </tr>
        <tr>
            <td><input class="control" value="Submit" type="submit"></td>
        </tr>
    </table>
    </sf:form>
</body>
</html>
