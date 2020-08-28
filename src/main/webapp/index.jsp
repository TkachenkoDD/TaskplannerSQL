<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Планировщик задач</title>
</head>
<body>
<h2>Планировщик задач</h2>
<form action="login" method="post">
    <fieldset>
        <legend>Вход на сайт</legend>
        Логин: <input type="text" name="login" required autocomplete="off"><br>
        Пароль: <input type="password" name="password" required><br>
        <a href="registration.jsp">Регистрация</a>
        <input type="submit" value="Войти">
<p>${warn}</p>
</fieldset>
</form>
</body>
</html>
