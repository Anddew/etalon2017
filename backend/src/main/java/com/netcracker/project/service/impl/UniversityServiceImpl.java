package com.netcracker.project.service.impl;

import com.netcracker.project.repository.UniversityRepository;
import com.netcracker.project.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public UniversityRepository getUniversityRepository() {
        return universityRepository;
    }

}
