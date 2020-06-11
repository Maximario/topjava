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
<p><a href="meal">Добавить прием пищи</a></p>
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
            <tr style="color: ${meal.excess ? 'red' : 'green'};">
                <td><a href="meal?id=${meal.id}">Изменить</a></td>
                <td><javatime:format value="${meal.dateTime}" pattern="yyyy-MM-dd HH:mm" /></td>
                <td><c:out value="${meal.description}" /></td>
                <td><c:out value="${meal.calories}" /></td>
                <td><a href="meal?id=${meal.id}&action=delete">Удалить</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
