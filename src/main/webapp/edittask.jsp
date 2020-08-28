<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Редактирование задачи</title>
</head>
<body>
<h2>Изменение задачи</h2>
<form action="taskedit" method="post">
    <input type="hidden" name = "editid" value="${param.editid}">
    Задача:<input type="text" name="edittext" value="${param.edittext}" placeholder="${param.edittext}"><br>
    Описание:<input type="text" name="editdescript" value="${param.editdescript}" placeholder="${param.editdescript}"><br>
    Срок выполнения:<input type="date" name="editdate" value="${param.editdate}" placeholder="${param.editdate}"><br>
    Статус задачи:  <input type="radio" name="editisdone" value="false" checked> В работе
                    <input type="radio" name="editisdone" value="true" >Выполнена<br>
    <input type="submit" value="Обновить">
</form>
</body>
</html>

