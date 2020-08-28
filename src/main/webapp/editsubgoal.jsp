<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Редактирование подцели</title>
</head>
<body>
<h2>Изменение подцели</h2>
<form action="subgoaledit" method="post">
    <input type="hidden" name="editsubgoal" value="${param.editsubgoal}">
    Редактировать подцель<input type="text" name="neweditsubgoal" value="${param.editsubgoal}"
                                placeholder="${param.editsubgoal}">
    <input type="submit" value="Обновить">
</form>
<!-- Добавление новой задачи в подцели -->
<h2>Добавление задачи в подцели</h2>
<form action="addtask.jsp" method="post">
    <input type="hidden" name="idgoal" value="${param.idgoal}">
    <input type="hidden" name="idofgoal" value="${param.idgoal}">
    <input type="hidden" name="editsubgoal" value="${param.editsubgoal}">
    <input type="hidden" name="idofsubgoal" value="${param.editsubgoal}">
    <input type="submit" value="Добавить задачу">
</form>
<h2>Удаление подцели</h2>
<form action="subgoaldelete" method="post">
    <input type="hidden" name="editsubgoal" value="${param.editsubgoal}">
    <input type="hidden" name="deletesubgoal" value="${param.editsubgoal}">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
