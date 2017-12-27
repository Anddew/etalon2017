package com.netcracker.project.entity.practice;

public enum PracticeStatus {

    CHECKED("Checked"),
    PROCESSING("Processing");

    private String description;

    PracticeStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
