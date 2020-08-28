<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Добавление задачи</title>
</head>
<body>
<h1>Добавление задачи</h1>
<form action="task" method="post">
    Текст задачи:<br> <input required type="text" name="task" autocomplete="off"><br>
    Описание:<br> <input required type="text" name="description" autocomplete="off"><br>
    Дата окончания:<br> <input required type="date" name="dateofend"><br>
    <input type="hidden" name="idofgoal" value="${param.idofgoal}">
    <input type="hidden" name="idofsubgoal" value="${param.idofsubgoal}">
    <input type="submit" value="Добавить задачу">
</form>
</body>
</html>

