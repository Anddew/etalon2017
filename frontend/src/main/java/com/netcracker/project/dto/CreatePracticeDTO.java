package com.netcracker.project.dto;

import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;

import java.sql.Date;

public class CreatePracticeDTO {

    private int studentRequiredCount;
    private int facultyId;
    private double minAvgScore;
    private EducationForm educationForm;
    private HireCondition hireCondition;
    private Date dateStart;
    private Date dateEnd;

    public CreatePracticeDTO() {
    }

    public CreatePracticeDTO(int studentRequiredCount,
                             int facultyId,
                             double minAvgScore,
                             EducationForm educationForm,
                             HireCondition hireCondition,
                             Date dateStart,
                             Date dateEnd) {
        this.studentRequiredCount = studentRequiredCount;
        this.facultyId = facultyId;
        this.minAvgScore = minAvgScore;
        this.educationForm = educationForm;
        this.hireCondition = hireCondition;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getStudentRequiredCount() {
        return studentRequiredCount;
    }

    public void setStudentRequiredCount(int studentRequiredCount) {
        this.studentRequiredCount = studentRequiredCount;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public double getMinAvgScore() {
        return minAvgScore;
    }

    public void setMinAvgScore(double minAvgScore) {
        this.minAvgScore = minAvgScore;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public HireCondition getHireCondition() {
        return hireCondition;
    }

    public void setHireCondition(HireCondition hireCondition) {
        this.hireCondition = hireCondition;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "CreatePracticeDTO{" +
                "studentRequiredCount=" + studentRequiredCount +
                ", facultyId=" + facultyId +
                ", minAvgScore=" + minAvgScore +
                ", educationForm=" + educationForm +
                ", hireCondition=" + hireCondition +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
