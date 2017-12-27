package com.netcracker.project.entity.user.student;

public enum  HireCondition {

    DENY("Not require"),
    ACCEPT("Require");


    private String description;

    HireCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
