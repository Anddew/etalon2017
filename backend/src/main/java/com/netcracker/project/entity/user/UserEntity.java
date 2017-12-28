package com.netcracker.project.entity.user;

import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.student.StudentEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;
import javax.persistence.CascadeType;

import java.sql.Timestamp;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "netcrackerappdb")
public class UserEntity {

    private int userId;
    private UserRole role;
    private String username;
    private String password;
    private String email;
    private Timestamp createTime;
    private String firstName;
    private String lastName;
    private CompanyEntity company;
    private FacultyEntity faculty;
    private StudentEntity studentInfo;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Enumerated(EnumType.STRING)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 15)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 15)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 15)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    public StudentEntity getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentEntity studentInfo) {
        this.studentInfo = studentInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, email, createTime, firstName, lastName);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + userId +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company=" + company +
                ", faculty=" + faculty +
                ", studentInfo=" + studentInfo +
                '}';
    }
    
}
