package com.netcracker.project.service;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllStudents();

    List<UserEntity> findAllHeadsFromCompany();

    List<UserEntity> findAllHeadsFromUniversity();

    List<UserEntity> findAllAdmins();

    UserEntity findUser(int id);

    List<UserEntity> findStudentsFromPractice(int id);

    UserEntity findUserByUserName(String username);

    void addUser(UserEntity user);

    List<PracticeEntity> getPractices(String username);

    void setStudentDetails(int id, double avgScore, EducationForm educationForm, HireCondition hireCondition);

}
