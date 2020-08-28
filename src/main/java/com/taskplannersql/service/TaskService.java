package com.taskplannersql.service;

import com.taskplannersql.beans.Task;

import java.sql.*;
import java.util.ArrayList;

/**
 * The TaskService class is used to perform the necessary operations with tasks:
 * -view all tasks from the database;
 * -adding a task to the database;
 * -edit a task in the database;
 */
public class TaskService {
    private static final String URL = "jdbc:postgresql://localhost:5432/tasks";
    private static final String ROOT_NAME = "task";
    private static final String SQL_PASSWORD = "mypassword";

    /**
     * Returns a list of all users tasks
     *
     * @param user - service user
     * @return list of tasks
     */
    public static ArrayList<Task> readAllTasks(String user) {
        ArrayList<Task> tasksFromSql = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "SELECT * from tasks WHERE taskowner = ?";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, user);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("text");
                String description = rs.getString("description");
                java.util.Date dateofend = rs.getDate("dateofend");
                boolean isdone = rs.getBoolean("isdone");
                String idofgoal = rs.getString("idofgoal");
                String idsubgoal = rs.getString("idsubgoal");
                Task task = new Task(id, text, description, dateofend, isdone, idofgoal, idsubgoal);
                tasksFromSql.add(task);
            }
            prst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
        return tasksFromSql;
    }

    /**
     * Creates a new task
     *
     * @param text        - text of task
     * @param description - description of task
     * @param dateOfEnd  - date of end
     * @param user - service user
     */
    public static void createTask(String text, String description, String dateOfEnd, String idOfGoal, String idOfSubGoal, String user) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "INSERT INTO tasks (text, description, dateOfEnd, isdone, idofgoal, idsubgoal, taskowner) Values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, text);
            prst.setString(2, description);
            prst.setDate(3, Date.valueOf(dateOfEnd));
            prst.setBoolean(4, false);
            prst.setString(5, idOfGoal);
            prst.setString(6, idOfSubGoal);
            prst.setString(7, user);
            prst.executeUpdate();
            prst.close();
        } catch (IllegalArgumentException | SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Deletes a task by ID
     *
     * @param id - id of task to be deleted
     */
    public static void deleteTask(int id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement pest = conn.prepareStatement(sql);
            pest.setInt(1, id);
            pest.executeUpdate();
            pest.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Edits the task with the given id,
     * in accordance with the transferred task parameters
     *
     * @param idTask      - id of the task to be updated
     * @param text        - text of task
     * @param description - description of task
     * @param dateOfEnd   - date of end
     * @param isDone      - task status (completed / in progress)
     */
    public static void edit(int idTask, String text, String description, String dateOfEnd, boolean isDone) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "UPDATE tasks SET text = ?, description = ?, dateofend = ?, isdone = ? WHERE id = ?";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, text);
            prst.setString(2, description);
            prst.setDate(3, Date.valueOf(dateOfEnd));
            prst.setBoolean(4, isDone);
            prst.setInt(5, idTask);
            prst.executeUpdate();
            prst.close();
        } catch (IllegalArgumentException | SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Returns a task by ID
     *
     * @param idTask - ID of task
     * @return task object with given ID
     */
    public static Task read(int idTask) {
        Task task = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "SELECT * FROM tasks WHERE id = ?";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setInt(1, idTask);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("text");
                String description = rs.getString("description");
                java.util.Date dateOfEnd = rs.getDate("dateofend");
                boolean isdone = rs.getBoolean("isdone");
                String idofgoal = rs.getString("idofgoal");
                String idsubgoal = rs.getString("idsubgoal");
                task = new Task(id, text, description, dateOfEnd, isdone, idofgoal, idsubgoal);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
        return task;
    }
}