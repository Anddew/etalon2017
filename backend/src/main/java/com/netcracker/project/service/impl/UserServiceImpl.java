package com.netcracker.project.service.impl;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.repository.UserRepository;
import com.netcracker.project.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserEntity> getStudents() {
        logger.debug("Get all students.");
        return userRepository.findByRole(UserRole.STUDENT);
    }

    @Override
    public List<UserEntity> getHeadsFromCompany() {
        logger.debug("Get all heads from company.");
        return userRepository.findByRole(UserRole.HEAD_FROM_COMPANY);
    }

    @Override
    public List<UserEntity> getHeadsFromUniversity() {
        logger.debug("Get all heads from university.");
        return userRepository.findByRole(UserRole.HEAD_FROM_UNIVERSITY);
    }

    @Override
    public List<UserEntity> getAdmins() {
        logger.debug("Get all admins.");
        return userRepository.findByRole(UserRole.ADMINISTRATOR);
    }

    @Override
    public UserEntity getUser(int id) {
        logger.debug("Get user id = '" + id + "'.");
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity getStudent(int id) {
        logger.debug("Get student id = '" + id + "'.");
        return userRepository.findStudentById(id);
    }

    @Override
    public List<UserEntity> getStudentsFromPractice(int practiceId) {
        logger.debug("Get students from practice id = '" + practiceId + "'.");
        return userRepository.findStudentsFromPractice(practiceId);
    }

    @Override
    public List<UserEntity> getAvailableStudents() {
        logger.debug("Get available students.");
        return userRepository.findAvailableStudents();
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        logger.debug("Get user username = '" + username + "'.");
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(UserEntity user) {
        userRepository.save(user);
        logger.info("New user has been successfully created.");
    }

    @Override
    public void setStudentDetails(int id, double avgScore, EducationForm educationForm, HireCondition hireCondition) {
        userRepository.saveStudentDetails(id, avgScore, educationForm, hireCondition);
        logger.debug("Student details have been successfully set for student id = '" + id + "'.");
    }

}
