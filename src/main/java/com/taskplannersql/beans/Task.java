package com.taskplannersql.beans;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private int idTask;
    private String text;
    private String description;
    private Date dateOfEnd;
    private boolean isDone;
    private String goal;
    private String subGoal;

    public Task() {
    }

    public Task(int idTask, String text, String description, Date dateOfEnd, boolean isDone, String goal, String subGoal) {
        this.idTask = idTask;
        this.text = text;
        this.description = description;
        this.dateOfEnd = dateOfEnd;
        this.isDone = isDone;
        this.goal = goal;
        this.subGoal = subGoal;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSubGoal() {
        return subGoal;
    }

    public void setSubGoal(String subGoal) {
        this.subGoal = subGoal;
    }

    @Override
    public String toString() {
        return "ID задачи: " + idTask + ", " +
                "Текст задачи: " + text + ", " +
                "Описание задачи: " + description + ", " +
                "Срок выполнения: " + dateOfEnd + ", " +
                "Статус выполнения: " + isDone + ", " +
                "Имя цели: " + goal + ", " +
                "Подцель: " + subGoal;
    }
}
