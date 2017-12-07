package com.netcracker.project.entity.user.student;

public enum  HireCondition {

    ACCEPT("Ready"),
    DENY("Not ready");

    private String description;

    HireCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
