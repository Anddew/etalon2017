package com.netcracker.project.entity.practice;

public enum RequestStatus {

    CHECKED("Checked"),
    PROCESSING("Processing");

    private String description;

    RequestStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
