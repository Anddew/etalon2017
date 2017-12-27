package com.netcracker.project.service;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;

import java.util.List;

public interface PracticeService {

    List<PracticeEntity> findAllPractices();

    PracticeEntity findById(int id);

}
