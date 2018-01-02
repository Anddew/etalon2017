package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.repository.SpecialityRepository;
import com.netcracker.project.service.SpecialityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private Logger logger = Logger.getLogger(SpecialityServiceImpl.class);


    @Autowired
    private SpecialityRepository specialityRepository;


    @Override
    public List<SpecialityEntity> getSpecialities() {
        logger.debug("Get all specialities.");
        return specialityRepository.findAll();
    }

    @Override
    public SpecialityEntity getSpeciality(int id) {
        logger.debug("Get speciality id = '" + id + "'.");
        return specialityRepository.findById(id);
    }

    @Override
    public void createSpeciality(SpecialityEntity speciality) {
        specialityRepository.save(speciality);
        logger.info("New speciality has been successfully created.");
    }

}
