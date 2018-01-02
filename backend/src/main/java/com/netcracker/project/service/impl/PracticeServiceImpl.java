package com.netcracker.project.service.impl;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.student.PracticeStatus;
import com.netcracker.project.entity.user.student.StudentEntity;
import com.netcracker.project.repository.PracticeRepository;
import com.netcracker.project.repository.StudentRepository;
import com.netcracker.project.service.PracticeService;
import com.netcracker.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    private Logger logger = Logger.getLogger(PracticeServiceImpl.class);


    @Autowired
    private UserService userService;

    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<PracticeEntity> getPractices() {
        logger.debug("Get all practices.");
        return practiceRepository.findAll();
    }

    @Override
    public List<PracticeEntity> getPractices(String username) {
        List<PracticeEntity> practices = null;
        UserEntity user = userService.getUserByUsername(username);
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
        logger.debug("Get practices for user '" + username + "'.");
        return practices;
    }

    @Override
    public PracticeEntity getPractice(int id) {
        return practiceRepository.findOne(id);
    }

    @Transactional
    @Override
    public void createPractice(PracticeEntity practice) {
        practiceRepository.save(practice);
        logger.info("New practice has been successfully created.");
    }

    @Transactional
    @Override
    public void assignStudents(Integer practiceId, List<Integer> studentsId) {
        PracticeEntity practice = practiceRepository.findOne(practiceId);
        List<StudentEntity> students = studentRepository.findAllByStudentIdIn(studentsId);
        for(StudentEntity student : students) {
            student.setPracticeStatus(PracticeStatus.WAITING);
        }
        practice.getStudents().addAll(students);
        logger.debug("Assign students to practice id = '" + practiceId + "' successfully.");
    }

    @Transactional
    @Override
    public void releaseStudents(Integer practiceId, List<Integer> studentsId) {
        PracticeEntity practice = practiceRepository.findOne(practiceId);
        List<StudentEntity> students = studentRepository.findAllByStudentIdIn(studentsId);
        for(StudentEntity student : students) {
            student.setPracticeStatus(PracticeStatus.AVAILABLE);
        }
        practice.getStudents().removeAll(students);
        logger.debug("Release students from practice id = '" + practiceId + "' successfully.");
    }

}
