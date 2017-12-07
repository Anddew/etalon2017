package com.netcracker.project.service.impl;

import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.repository.FacultyRepository;
import com.netcracker.project.repository.UniversityRepository;
import com.netcracker.project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyRepository getFacultyRepository() {
        return facultyRepository;
    }


    @Override
    public List<FacultyEntity> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public FacultyEntity getFacultyById(int facultyId) {
        return facultyRepository.findById(facultyId);
    }

    @Override
    public void addFaculty(FacultyEntity university) {
        facultyRepository.save(university);
    }

}
