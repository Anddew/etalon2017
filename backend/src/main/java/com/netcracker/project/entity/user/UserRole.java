package com.netcracker.project.entity.user;

public enum UserRole {

    ADMINISTRATOR("Administrator"),
    HEAD_FROM_COMPANY("Head from company"),
    HEAD_FROM_UNIVERSITY("Head from university"),
    STUDENT("Student");

    private String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
