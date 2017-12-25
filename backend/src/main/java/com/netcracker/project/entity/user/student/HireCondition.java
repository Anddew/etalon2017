package com.netcracker.project.entity.user.student;

public enum  HireCondition {

    ACCEPT("Require"),
    DENY("Not require");

    private String description;

    HireCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
