package com.netcracker.project.entity.user.student;

public enum EducationForm {

    FULL_TIME("Full-Time"),
    PART_TIME("Part-Time"),
    EVENING("Evening"),
    DISTANCE("Distance");


    private String description;

    EducationForm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
