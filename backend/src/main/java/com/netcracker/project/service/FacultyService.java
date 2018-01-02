package com.netcracker.project.service;

import com.netcracker.project.entity.university.FacultyEntity;

import java.util.List;

public interface FacultyService {

    List<FacultyEntity> getFaculties();

    FacultyEntity getFaculty(int id);

    void createFaculty(FacultyEntity faculty);

    List<FacultyEntity> getFacultiesByUniversityId(int universityId);

}
