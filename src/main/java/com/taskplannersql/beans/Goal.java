package com.taskplannersql.beans;

import java.io.Serializable;

public class Goal implements Serializable {
    private String goalName;
    private String subGoal;

    public Goal() {
    }

    public Goal(String goalName, String subGoal) {
        this.goalName = goalName;
        this.subGoal = subGoal;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getSubGoal() {
        return subGoal;
    }

    public void setSubGoal(String subGoal) {
        this.subGoal = subGoal;
    }
}
