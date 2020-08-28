<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Планировщик задач</title>
</head>
<body>
<h1>Планировщик задач</h1>
<h2>Цели</h2>
<!-- Цели -->
<c:forEach var="goal" items="${goals}">
    <details>
        <summary><strong>Цель: ${goal.getGoalName()}</strong>
            <!-- Редактирование выбранной цели -->
            <form action="editgoal.jsp" method="post">
                <input type="hidden" name="editgoal" value="${goal.getGoalName()}">
                <input type="submit" value="Редактировать">
            </form>
        </summary>
        <!-- Подцели -->
        <c:forEach var="sub" items="${subgoals}">
            <c:if test="${goal.getGoalName() == sub.getIdGoal()}">
                <details open="open">
                    <summary>Подцель: ${sub.getSubGoalName()}
                        <!-- Редактирование выбранной подцели -->
                        <form action="editsubgoal.jsp" method="post">
                            <input type="hidden" name="editsubgoal" value="${sub.getSubGoalName()}">
                            <input type="hidden" name="idgoal" value="${goal.getGoalName()}">
                            <input type="submit" value="Редактировать">
                        </form>
                    </summary>
                    <!-- Задачи -->
                    <c:forEach var="task" items="${tasks}">
                        <c:if test="${task.getSubGoal() == sub.getSubGoalName() && task.getGoal() == goal.getGoalName()}">
                            <p>id задачи:${task.getIdTask()},
                                Задача:${task.getText()},
                                Описание:${task.getDescription()},
                                Срок выполнения:${task.getDateOfEnd()},
                                Статус:<c:if test="${task.isDone() == true}">Выполнена</c:if>
                                <c:if test="${task.isDone() == false}">В работе</c:if>,
                                Цель: ${task.getGoal()},
                                Подцель: ${task.getSubGoal()}
                            </p>
                        </c:if>
                    </c:forEach>
                </details>
            </c:if>
        </c:forEach>
        <hr>
        Задачи без подцелей
        <!--Задачи без подцелей-->
        <c:forEach var="task" items="${tasks}">
            <c:if test="${task.getSubGoal() == '' && task.getGoal() == goal.getGoalName()}">
                <p>id задачи:${task.getIdTask()},
                    Задача:${task.getText()},
                    Описание:${task.getDescription()},
                    Срок выполнения:${task.getDateOfEnd()},
                    Статус:<c:if test="${task.isDone() == true}">Выполнена</c:if>
                    <c:if test="${task.isDone() == false}">В работе</c:if>,
                    Цель: ${task.getGoal()},
                    Подцель: ${task.getSubGoal()}
                </p>
            </c:if>
        </c:forEach>
    </details>
</c:forEach>
<hr>
<hr>
<!-- Добавление новой цели -->
<form action="addgoal.jsp" method="post">
    <input type="submit" value="Добавить цель">
</form>
<hr>
<!-- Перечень всех задач -->
<h2>Все задачи</h2>
<table border="1">
    <tr>
        <td>ID задачи</td>
        <td>Задачи</td>
        <td>Описание</td>
        <td>Дата окончания</td>
        <td>Статус</td>
        <td>Цель</td>
        <td>Подцель</td>
        <td>Действия</td>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.getIdTask()}</td>
            <td>${task.getText()}</td>
            <td>${task.getDescription()}</td>
            <td>${task.getDateOfEnd()}</td>
            <td><c:if test="${task.isDone() == true}"><p>Выполнена</p></c:if>
                <c:if test="${task.isDone() == false}"><p>В работе</p></c:if></td>
            <td>${task.getGoal()}</td>
            <td>${task.getSubGoal()}</td>
            <td>
                <!-- Удаление выбранной задачи -->
                <form action="taskdel" method="post">
                    <input type="hidden" name="id" value="${task.getIdTask()}">
                    <input type="submit" value="Удалить">
                </form>
                <!-- Редактирование выбранной задачи -->
                <form action="edittask.jsp" method="post">
                    <input type="hidden" name="editid" value="${task.getIdTask()}">
                    <input type="hidden" name="edittext" value="${task.getText()}">
                    <input type="hidden" name="editdescript" value="${task.getDescription()}">
                    <input type="hidden" name="editdate" value="${task.getDateOfEnd()}">
                    <input type="hidden" name="editisdone" value="${task.isDone()}">
                    <input type="submit" value="Редактировать">
                </form>
            </td>
        </tr>
    </c:forEach>
    <br>
</table>
<p>${text}</p>
<!-- Добавление новой задачи -->
<form action="addtask.jsp" method="post">
    <input type="submit" value="Добавить задачу">
</form>
<!-- Поиск задачи по ID -->
<form action="readid" method="get">
    Поиск задачи по ID:<input required type="text" name="id" autocomplete="off"><br>
    <input type="submit" value="Найти">
</form>
<p>${task}</p>
<hr>
<!-- Выход из сервиса -->
<form action="login" method="get">
    <input type="submit" value="Выйти">
</form>
</body>
</html>
