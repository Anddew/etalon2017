package com.netcracker.project.service.impl;

import com.netcracker.project.repository.StudentRepository;
import com.netcracker.project.repository.UserRepository;
import com.netcracker.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
