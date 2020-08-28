package com.taskplannersql.beans;

import java.io.Serializable;

public class SubGoal implements Serializable {
    private String subGoalName;
    private String idGoal;

    public SubGoal() {
    }

    public SubGoal(String subGoalName, String idGoal) {
        this.subGoalName = subGoalName;
        this.idGoal = idGoal;
    }

    public String getSubGoalName() {
        return subGoalName;
    }

    public void setSubGoalName(String subGoalName) {
        this.subGoalName = subGoalName;
    }

    public String getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(String idGoal) {
        this.idGoal = idGoal;
    }
}
