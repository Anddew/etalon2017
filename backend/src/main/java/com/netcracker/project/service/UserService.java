package com.netcracker.project.service;

import com.netcracker.project.entity.user.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserEntity> findAllStudents();

    List<UserEntity> findAllHeadsFromCompany();

    List<UserEntity> findAllHeadsFromUniversity();

    List<UserEntity> findAllAdmins();

    UserEntity findById(int id);

    UserEntity findUserByUserName(String username);

    void addUser(UserEntity user);

}
