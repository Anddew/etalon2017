package com.netcracker.project.bean.user;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.user.UserRole;

import java.util.Objects;

public class StudentViewModel extends UserViewModel {

    private static final long serialVersionUID = -5030508116953769658L;

    private String studentId;
    private String educationForm;
    private SpecialityViewModel speciality;
    private String groupNumber;
    private String avgScore;
    private String hireCondition;
    private String practiceStatus;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getHireCondition() {
        return hireCondition;
    }

    public void setHireCondition(String hireCondition) {
        this.hireCondition = hireCondition;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentViewModel that = (StudentViewModel) o;
        return  Objects.equals(studentId, that.studentId) &&
                Objects.equals(educationForm, that.educationForm) &&
                Objects.equals(speciality, that.speciality) &&
                Objects.equals(groupNumber, that.groupNumber) &&
                Objects.equals(avgScore, that.avgScore) &&
                Objects.equals(hireCondition, that.hireCondition) &&
                Objects.equals(practiceStatus, that.practiceStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, educationForm, speciality, groupNumber, avgScore, hireCondition, practiceStatus);
    }

    @Override
    public String toString() {
        return "StudentViewModel{" +
                "studentId='" + studentId + '\'' +
                ", educationForm='" + educationForm + '\'' +
                ", speciality=" + speciality +
                ", groupNumber='" + groupNumber + '\'' +
                ", avgScore='" + avgScore + '\'' +
                ", hireCondition='" + hireCondition + '\'' +
                ", practiceStatus='" + practiceStatus + '\'' +
                "} " + super.toString();
    }

}
