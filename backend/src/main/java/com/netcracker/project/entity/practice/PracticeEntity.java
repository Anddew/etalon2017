package com.netcracker.project.entity.practice;

import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "practice", schema = "netcrackerappdb")
public class PracticeEntity {

    private int id;
    private PracticeStatus status;
    private FacultyEntity faculty;
    private int studentRequiredCount;
    private double minAvgScore;
    private HireCondition hireCondition;
    private Date dateStart;
    private Date dateEnd;
    private EducationForm educationForm;
    private UserEntity headFromCompany;
    private UserEntity headFromUniversity;
    private List<StudentEntity> students = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public PracticeStatus getStatus() {
        return status;
    }

    public void setStatus(PracticeStatus practiceStatus) {
        this.status = practiceStatus;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    @Basic
    @Column(name = "student_required_count", nullable = false)
    public int getStudentRequiredCount() {
        return studentRequiredCount;
    }

    public void setStudentRequiredCount(int studentRequiredCount) {
        this.studentRequiredCount = studentRequiredCount;
    }

    @Basic
    @Column(name = "min_avg_score", nullable = true, precision = 0)
    public double getMinAvgScore() {
        return minAvgScore;
    }

    public void setMinAvgScore(double minAvgScore) {
        this.minAvgScore = minAvgScore;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "hire_condition")
    public HireCondition getHireCondition() {
        return hireCondition;
    }

    public void setHireCondition(HireCondition hireCondition) {
        this.hireCondition = hireCondition;
    }

    @Basic
    @Column(name = "date_start", nullable = false)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end", nullable = false)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
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
    @JoinColumn(name = "head_from_company_id")
    public UserEntity getHeadFromCompany() {
        return headFromCompany;
    }

    public void setHeadFromCompany(UserEntity headFromCompany) {
        this.headFromCompany = headFromCompany;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_from_university_id")
    public UserEntity getHeadFromUniversity() {
        return headFromUniversity;
    }

    public void setHeadFromUniversity(UserEntity headFromUniversity) {
        this.headFromUniversity = headFromUniversity;
    }

    @Transactional
    @ManyToMany(mappedBy = "practices")
    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeEntity that = (PracticeEntity) o;
        return id == that.id &&
                studentRequiredCount == that.studentRequiredCount &&
                Objects.equals(minAvgScore, that.minAvgScore) &&
                Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentRequiredCount, minAvgScore, dateStart, dateEnd);
    }

    @Override
    public String toString() {
        return "PracticeEntity{" +
                "id=" + id +
                ", status=" + status +
                ", faculty=" + faculty +
                ", studentRequiredCount=" + studentRequiredCount +
                ", minAvgScore=" + minAvgScore +
                ", hireCondition=" + hireCondition +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", educationForm=" + educationForm +
                '}';
    }

}