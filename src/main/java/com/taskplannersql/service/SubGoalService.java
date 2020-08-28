package com.taskplannersql.service;

import com.taskplannersql.beans.SubGoal;

import java.sql.*;
import java.util.ArrayList;

/**
 * The SubGoalService class is used to perform the necessary operations with subgoals:
 * -view all subgoals from the database;
 * -adding a subgoal to the database;
 * -edit a subgoal in the database;
 */
public class SubGoalService {
    private static final String URL = "jdbc:postgresql://localhost:5432/tasks";
    private static final String ROOT_NAME = "task";
    private static final String SQL_PASSWORD = "mypassword";

    /**
     * Creates a new subgoal
     *
     * @param goalName - name of goal
     * @param subGoal  - name of subgoal
     * @param user     - authorized user
     */
    public static void createSubGoal(String subGoal, String goalName, String user) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "INSERT INTO subgoals (subgoalname, idgoal, subgoalowner) VALUES (?, ?, ?)";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, subGoal);
            prst.setString(2, goalName);
            prst.setString(3, user);
            prst.executeUpdate();
            prst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Returns a list of all users subgoals
     *
     * @param user - service user
     * @return list of subgoals
     */
    public static ArrayList<SubGoal> readSubGoals(String user) {
        ArrayList<SubGoal> subGoalsFromSql = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sql = "SELECT * FROM subgoals WHERE subgoalowner = ?";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.setString(1, user);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                String subGoalName = rs.getString("subgoalname");
                String idGoal = rs.getString("idgoal");
                SubGoal sub = new SubGoal(subGoalName, idGoal);
                subGoalsFromSql.add(sub);
            }
            prst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
        return subGoalsFromSql;
    }

    /**
     * Edits a subgoal
     *
     * @param subGoalName    - subgoal name
     * @param newSubGoalName - new subgoal name
     */
    public static void editSubGoal(String subGoalName, String newSubGoalName) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sqlSubGoals = "UPDATE subgoals SET subgoalname = ? WHERE subgoalname = ?";
            String sqlTasks = "UPDATE tasks SET idsubgoal = ? WHERE idsubgoal = ?";
            PreparedStatement prst1 = conn.prepareStatement(sqlTasks);
            PreparedStatement prst2 = conn.prepareStatement(sqlSubGoals);
            prst1.setString(1, newSubGoalName);
            prst1.setString(2, subGoalName);
            prst2.setString(1, newSubGoalName);
            prst2.setString(2, subGoalName);
            prst1.executeUpdate();
            prst2.executeUpdate();
            prst1.close();
            prst2.close();
        } catch (IllegalArgumentException | SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Deletes a subgoal
     *
     * @param subGoalName - subgoal to be deleted
     */
    public static void deleteSubGoal(String subGoalName) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(URL, ROOT_NAME, SQL_PASSWORD);
            String sqlsubgoals = "DELETE FROM subgoals WHERE subgoalname=?";
            String sqltasks = "UPDATE tasks SET idsubgoal = '' WHERE idsubgoal = ?";
            PreparedStatement prst1 = conn.prepareStatement(sqlsubgoals);
            PreparedStatement prst2 = conn.prepareStatement(sqltasks);
            prst1.setString(1, subGoalName);
            prst2.setString(1, subGoalName);
            prst1.executeUpdate();
            prst2.executeUpdate();
            prst1.close();
            prst2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}
