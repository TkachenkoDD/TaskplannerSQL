<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Добавление подцели</title>
</head>
<body>
<h1>Добавление подцели</h1>
<form action="subgoal" method="post">
    Подцель:<br> <input required type="text" name="subgoalname" autocomplete="off"><br>
    <input type="hidden" name="idgoal" value="${param.idgoal}">
    <input type="submit" value="Добавить подцель">
</form>
</body>
</html>
