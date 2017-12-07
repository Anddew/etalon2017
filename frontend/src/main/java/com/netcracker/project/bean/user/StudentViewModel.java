package com.netcracker.project.bean.user;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.user.UserRole;

public class StudentViewModel extends UserViewModel {

    private String id;
    private String educationForm;
    private SpecialityViewModel speciality;
    private String groupNumber;
    private String avgScore;
    private String requiredJob;
    private String practiceStatus;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public SpecialityViewModel getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityViewModel speciality) {
        this.speciality = speciality;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }

    public String getRequiredJob() {
        return requiredJob;
    }

    public void setRequiredJob(String requiredJob) {
        this.requiredJob = requiredJob;
    }

    public String getPracticeStatus() {
        return practiceStatus;
    }

    public void setPracticeStatus(String practiceStatus) {
        this.practiceStatus = practiceStatus;
    }

    @Override
    public UserRole getRole() {
        return UserRole.STUDENT;
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "id='" + id + '\'' +
                ", educationForm='" + educationForm + '\'' +
                ", speciality=" + speciality +
                ", groupNumber='" + groupNumber + '\'' +
                ", avgScore='" + avgScore + '\'' +
                ", requiredJob='" + requiredJob + '\'' +
                ", practiceStatus='" + practiceStatus + '\'' +
                "} " + super.toString();
    }
}
