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
    <form method="post">
        <p>
            <input type="hidden" name="id" value="${meal.id}"><br/>
            Дата и время <input type="datetime-local" name="dateTime" value="${meal.dateTime}"><br/>
            Описание <input type="text" name="description" value="${meal.description}"><br/>
            Калории <input type="number" name="calories" value="${meal.calories}"><br/>
            <input type="submit" name="Save">
        </p>
    </form>
</body>
</html>
