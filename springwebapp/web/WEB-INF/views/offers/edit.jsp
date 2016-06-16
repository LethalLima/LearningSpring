<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LethalLima
  Date: 6/13/16
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/offers.css" type="text/css">
    <title>Edit Offer</title>
</head>
<body>
    <sf:form class="table-form" method="post" action="/offers/${offer.id}" modelAttribute="offer">
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
                <td><input class="control" value="Save Changes" type="submit"></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
