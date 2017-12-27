package com.netcracker.project.entity.user.student;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.university.SpecialityEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student", schema = "netcrackerappdb")
public class StudentEntity {

    private int studentId;
    private EducationForm educationForm;
    private SpecialityEntity speciality;
    private int groupNumber;
    private Double avgScore;
    private boolean requiredJob;
    private PracticeStatus practiceStatus;
    private List<PracticeEntity> practices = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "education_form")
    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_id")
    public SpecialityEntity getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityEntity speciality) {
        this.speciality = speciality;
    }

    @Basic
    @Column(name = "group_number", nullable = false)
    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Basic
    @Column(name = "avg_score", nullable = true, precision = 0)
    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    @Basic
    @Column(name = "required_job", nullable = true)
    public boolean getRequiredJob() {
        return requiredJob;
    }

    public void setRequiredJob(boolean requiredJob) {
        this.requiredJob = requiredJob;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "practice_status")
    public PracticeStatus getPracticeStatus() {
        return practiceStatus;
    }

    public void setPracticeStatus(PracticeStatus practiceStatus) {
        this.practiceStatus = practiceStatus;
    }

    @Transactional
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "practice_student",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "practice_id") }
    )
    public List<PracticeEntity> getPractices() {
        return practices;
    }

    public void setPractices(List<PracticeEntity> practices) {
        this.practices = practices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return studentId == that.studentId &&
                groupNumber == that.groupNumber &&
                Objects.equals(avgScore, that.avgScore) &&
                Objects.equals(requiredJob, that.requiredJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, groupNumber, avgScore, requiredJob);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + studentId +
                ", educationForm=" + educationForm +
                ", speciality=" + speciality +
                ", groupNumber=" + groupNumber +
                ", avgScore=" + avgScore +
                ", requiredJob=" + requiredJob +
                ", practiceStatus=" + practiceStatus +
                '}';
    }

}
