package com.netcracker.project.bean.practice;

import com.netcracker.project.bean.university.FacultyViewModel;

public class RequestViewModel {

    private String id;
    private String status;
    private FacultyViewModel faculty;
    private String studentRequiredCount;
    private String minAvgScore;
    private String hireCondition;
    private String dateStart;
    private String dateEnd;
    private String educationForm;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FacultyViewModel getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyViewModel faculty) {
        this.faculty = faculty;
    }

    public String getStudentRequiredCount() {
        return studentRequiredCount;
    }

    public void setStudentRequiredCount(String studentRequiredCount) {
        this.studentRequiredCount = studentRequiredCount;
    }

    public String getMinAvgScore() {
        return minAvgScore;
    }

    public void setMinAvgScore(String minAvgScore) {
        this.minAvgScore = minAvgScore;
    }

    public String getHireCondition() {
        return hireCondition;
    }

    public void setHireCondition(String hireCondition) {
        this.hireCondition = hireCondition;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

}
