package com.netcracker.project.service;

import com.netcracker.project.entity.practice.PracticeEntity;

import java.util.List;

public interface PracticeService {

    List<PracticeEntity> getPractices();

    List<PracticeEntity> getPractices(String username);

    PracticeEntity getPractice(int id);

    void createPractice(PracticeEntity practice);

    void assignStudents(Integer practiceId, List<Integer> studentsId);

    void releaseStudents(Integer practiceId, List<Integer> studentsId);

}
