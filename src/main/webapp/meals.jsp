<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %><%--
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
    <style type="text/css">
        .normal { color: green; }
        .exceed { color: red; }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<p><a href="meal?action=create">Добавить прием пищи</a></p>
<table>
    <thead>
        <tr align="center" style="font-weight: bold;">
            <td></td>
            <td>Время</td>
            <td>Описание</td>
            <td>Калории</td>
            <td></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="meal" items="${meals}">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo" />
            <tr class="${meal.excess ? 'exceed' : 'normal'}">
                <td><a href="meal?action=update&id=${meal.id}">Изменить</a></td>
                <td>
<%--                    <javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm" />--%>
                    <%=TimeUtil.toString(meal.getDateTime())%>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meal?action=delete&id=${meal.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
