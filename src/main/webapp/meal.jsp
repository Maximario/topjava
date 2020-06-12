<%--
  Created by IntelliJ IDEA.
  User: mgrevtsov
  Date: 10.06.2020
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <h2><a href="">Home</a></h2>
    <h3>Meal</h3>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}"><br/>
        <dl>
            <dt>Дата и время</dt>
            <dd><input type="datetime-local" name="dateTime" value="${meal.dateTime}"></dd>
        </dl>
        <dl>
            <dt>Описание</dt>
            <dd><input type="text" name="description" size="50" value="${meal.description}"></dd>
        </dl>
        <dl>
            <dt>Калории</dt>
            <dd><input type="number" name="calories" value="${meal.calories}"></dd>
        </dl>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</body>
</html>
