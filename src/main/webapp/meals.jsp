<%--
  Created by IntelliJ IDEA.
  User: mgrevtsov
  Date: 09.06.2020
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table>
    <thead>
        <tr align="center" style="font-weight: bold;">
            <td>Время</td>
            <td>Описание</td>
            <td>Калории</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="meal" items="${meals}">
            <c:choose>
                <c:when test="${meal.excess}">
                    <c:set var="mealColor" value="red" />
                </c:when>
                <c:otherwise>
                    <c:set var="mealColor" value="green" />
                </c:otherwise>
            </c:choose>
            <tr bgcolor="${mealColor}">
                <td><javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm" /></td>
                <td><c:out value="${meal.description}" /></td>
                <td><c:out value="${meal.calories}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
