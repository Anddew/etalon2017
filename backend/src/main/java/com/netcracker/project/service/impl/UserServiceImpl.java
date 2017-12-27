package com.netcracker.project.service.impl;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.repository.PracticeRepository;
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

    @Autowired
    private PracticeRepository practiceRepository;


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
    public List<UserEntity> findStudentsFromPractice(int id) {
        return userRepository.findStudentsFromPractice(id);
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

    @Override
    public List<PracticeEntity> getPractices(String username) {
        List<PracticeEntity> practices = null;
        UserEntity user = findUserByUserName(username);
        UserRole role = user.getRole();
        switch (role) {
            case ADMINISTRATOR: {
                practices = practiceRepository.findAll();
                break;
            }
            case STUDENT: {
                practices = user.getStudentInfo().getPractices();
                break;
            }
            case HEAD_FROM_UNIVERSITY: {
                practices = practiceRepository.findAllByHeadFromUniversity(user);
                break;
            }
            case HEAD_FROM_COMPANY: {
                practices = practiceRepository.findAllByHeadFromCompany(user);
                break;
            }
        }
        return practices;
    }

}
