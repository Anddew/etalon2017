package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.repository.SpecialityRepository;
import com.netcracker.project.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;


    @Override
    public List<SpecialityEntity> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public SpecialityEntity getSpecialityById(int specialityId) {
        return specialityRepository.findById(specialityId);
    }

    @Override
    public void addSpeciality(SpecialityEntity speciality) {
        specialityRepository.save(speciality);
    }

}
