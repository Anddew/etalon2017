package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.repository.UniversityRepository;
import com.netcracker.project.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;


    @Override
    public UniversityEntity getUniversityById(int universityId) {
        return universityRepository.findById(universityId);
    }

    @Override
    public void addUniversity(UniversityEntity university) {
        universityRepository.save(university);
    }

    @Override
    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }

}
