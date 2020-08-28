<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Добавление цели</title>
</head>
<body>
<h1>Добавление цели</h1>
<form action="goal" method="post">
    Цель:<br> <input required type="text" name="goalname" autocomplete="off"><br>
    <input type="submit" value="Добавить цель">
</form>
</body>
</html>
