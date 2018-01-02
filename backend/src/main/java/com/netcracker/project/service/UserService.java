package com.netcracker.project.service;

import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;

import java.util.List;

public interface UserService {

    List<UserEntity> getStudents();

    List<UserEntity> getHeadsFromCompany();

    List<UserEntity> getHeadsFromUniversity();

    List<UserEntity> getAdmins();

    UserEntity getStudent(int id);

    List<UserEntity> getStudentsFromPractice(int practiceId);

    List<UserEntity> getAvailableStudents();

    UserEntity getUserByUsername(String username);

    void addUser(UserEntity user);

    void setStudentDetails(int id, double avgScore, EducationForm educationForm, HireCondition hireCondition);

}
