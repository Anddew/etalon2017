package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.repository.UniversityRepository;
import com.netcracker.project.service.UniversityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private Logger logger = Logger.getLogger(UniversityServiceImpl.class);


    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<UniversityEntity> getUniversities() {
        logger.debug("Get all universities.");
        return universityRepository.findAll();
    }

    @Override
    public UniversityEntity getUniversity(int id) {
        logger.debug("Get university id = '" + id + "'.");
        return universityRepository.findById(id);
    }

    @Override
    public void createUniversity(UniversityEntity university) {
        universityRepository.save(university);
        logger.info("New university has been successfully created.");
    }

}
