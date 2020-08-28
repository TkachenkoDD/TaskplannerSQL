<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="reg" method="post">
    Введите логин:<br> <input required type="text" name="newlogin" autocomplete="off"><br>
    Введите пароль:<br> <input required type="text" name="newpassword" autocomplete="off"><br>
    <input type="submit" value="Зарегистрироваться">
</form>
<p>${warn1}</p>
</body>
</html>

