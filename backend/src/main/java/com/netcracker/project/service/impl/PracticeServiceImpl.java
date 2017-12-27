package com.netcracker.project.service.impl;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.repository.PracticeRepository;
import com.netcracker.project.repository.UserRepository;
import com.netcracker.project.service.PracticeService;
import com.netcracker.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;


    @Override
    public List<PracticeEntity> findAllPractices() {
        return practiceRepository.findAll();
    }

    @Override
    public PracticeEntity findById(int id) {
        return practiceRepository.findOne(id);
    }

}
