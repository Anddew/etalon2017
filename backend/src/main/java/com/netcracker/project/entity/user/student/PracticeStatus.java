package com.netcracker.project.entity.user.student;

public enum PracticeStatus {

    AVAILABLE("Available"),
    WAITING("Waiting"),
    ON_PRACTICE("On practice");


    private String description;

    PracticeStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
