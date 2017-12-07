package com.netcracker.project.service;

import com.netcracker.project.entity.university.FacultyEntity;

import java.util.List;
import java.util.Set;

public interface FacultyService {

    List<FacultyEntity> getAllFaculties();

    FacultyEntity getFacultyById(int facultyId);

    void addFaculty(FacultyEntity faculty);

}
