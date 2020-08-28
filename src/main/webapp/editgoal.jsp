<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Редактирование цели</title>
</head>
<body>
<h2>Изменение цели</h2>
<!-- Редактировать имя цели -->
<form action="goaledit" method="post">
    <input type="hidden" name="editgoal" value="${param.editgoal}">
    Редактировать цель:<input type="text" name="neweditgoal" value="${param.editgoal}" placeholder="${param.editgoal}"><br>
    <input type="submit" value="Обновить">
</form>
<!-- Добавление подцели -->
<form action="subgoal" method="post">
    <input type="hidden" name="editgoal" value="${param.editgoal}">
    Добавить подцель:<br> <input required type="text" name="subgoalname" autocomplete="off"><br>
    <input type="hidden" name="idgoal" value="${param.editgoal}">
    <input type="submit" value="Добавить подцель">
</form>
<!-- Добавление новой задачи в цели -->
<form action="addtask.jsp" method="post">
    <input type="hidden" name="editgoal" value="${param.editgoal}">
    <input type="hidden" name="idofgoal" value="${param.editgoal}">
    <input type="submit" value="Добавить задачу">
</form>
<!-- Удаление цели -->
<h2>Удаление цели</h2>
Так же удалит вложенные подцели и задачи
<form action="goaldel" method="post">
    <input type="hidden" name="editgoal" value="${param.editgoal}">
    <input type="hidden" name="goalname" value="${param.editgoal}">
    <input type="submit" value="Удалить">
</form>
</body>
</html>


