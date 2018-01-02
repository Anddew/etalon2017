package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.repository.FacultyRepository;
import com.netcracker.project.service.FacultyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private Logger logger = Logger.getLogger(FacultyServiceImpl.class);


    @Autowired
    private FacultyRepository facultyRepository;


    @Override
    public List<FacultyEntity> getFaculties() {
        logger.debug("Get all faculties.");
        return facultyRepository.findAll();
    }

    @Override
    public FacultyEntity getFaculty(int id) {
        logger.debug("Get faculty id = '" + id + "'.");
        return facultyRepository.findOne(id);
    }

    @Override
    public List<FacultyEntity> getFacultiesByUniversityId(int universityId) {
        logger.debug("Get faculties for university id = '" + universityId + "'.");
        return facultyRepository.findFacultiesByUniversityId(universityId);
    }

    @Override
    public void createFaculty(FacultyEntity faculty) {
        facultyRepository.save(faculty);
        logger.info("New faculty has been successfully created.");
    }

}
