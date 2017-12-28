package com.netcracker.project.service;

import com.netcracker.project.entity.practice.PracticeEntity;

import java.util.List;

public interface PracticeService {

    List<PracticeEntity> findAllPractices();

    PracticeEntity findById(int id);

    void createPractice(PracticeEntity practice);

}
