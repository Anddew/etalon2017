package com.netcracker.project.service.impl;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.repository.PracticeRepository;
import com.netcracker.project.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void createPractice(PracticeEntity practice) {
        practiceRepository.save(practice);
    }

}
