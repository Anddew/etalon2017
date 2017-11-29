package com.netcracker.project.service.impl;

import com.netcracker.project.repository.FacultyRepository;
import com.netcracker.project.repository.UniversityRepository;
import com.netcracker.project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyRepository getFacultyRepository() {
        return facultyRepository;
    }

}
