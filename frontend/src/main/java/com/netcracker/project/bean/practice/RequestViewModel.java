package com.netcracker.project.bean.practice;

import com.netcracker.project.bean.university.FacultyViewModel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestViewModel that = (RequestViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(status, that.status) &&
                Objects.equals(faculty, that.faculty) &&
                Objects.equals(studentRequiredCount, that.studentRequiredCount) &&
                Objects.equals(minAvgScore, that.minAvgScore) &&
                Objects.equals(hireCondition, that.hireCondition) &&
                Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateEnd, that.dateEnd) &&
                Objects.equals(educationForm, that.educationForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, faculty, studentRequiredCount, minAvgScore, hireCondition, dateStart, dateEnd, educationForm);
    }

    @Override
    public String toString() {
        return "RequestViewModel{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", faculty=" + faculty +
                ", studentRequiredCount='" + studentRequiredCount + '\'' +
                ", minAvgScore='" + minAvgScore + '\'' +
                ", hireCondition='" + hireCondition + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", educationForm='" + educationForm + '\'' +
                '}';
    }

}
