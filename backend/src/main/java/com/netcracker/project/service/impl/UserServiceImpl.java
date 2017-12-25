package com.netcracker.project.service.impl;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import com.netcracker.project.repository.StudentRepository;
import com.netcracker.project.repository.UserRepository;
import com.netcracker.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Override
    public List<UserEntity> findAllStudents() {
        return userRepository.findByRole(UserRole.STUDENT);
    }

    @Override
    public List<UserEntity> findAllHeadsFromCompany() {
        return userRepository.findByRole(UserRole.HEAD_FROM_COMPANY);
    }

    @Override
    public List<UserEntity> findAllHeadsFromUniversity() {
        return userRepository.findByRole(UserRole.HEAD_FROM_UNIVERSITY);
    }

    @Override
    public List<UserEntity> findAllAdmins() {
        return userRepository.findByRole(UserRole.ADMINISTRATOR);
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public UserEntity findStudent(int id) {
        return userRepository.findStudentById(id);
    }

    @Override
    public UserEntity findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(UserEntity user) {

        userRepository.save(user);
    }

    @Override
    public UserEntity findStudentByUsername(String username) {
        return userRepository.findByUsernameAndRole(username, UserRole.STUDENT);
    }

}
