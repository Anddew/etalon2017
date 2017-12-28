package com.netcracker.project.service;

import com.netcracker.project.entity.university.FacultyEntity;

import java.util.List;

public interface FacultyService {

    List<FacultyEntity> getAllFaculties();

    FacultyEntity getFacultyById(int id);

    void createFaculty(FacultyEntity faculty);

    List<FacultyEntity> getFacultiesByUniversityId(int id);

}
