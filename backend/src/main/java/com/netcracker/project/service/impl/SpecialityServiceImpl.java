package com.netcracker.project.service.impl;

import com.netcracker.project.repository.FacultyRepository;
import com.netcracker.project.repository.SpecialityRepository;
import com.netcracker.project.service.FacultyService;
import com.netcracker.project.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    public SpecialityRepository getSpecialityRepository() {
        return specialityRepository;
    }

}
