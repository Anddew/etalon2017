package com.netcracker.project.service;

import com.netcracker.project.entity.university.UniversityEntity;

import java.util.List;

public interface UniversityService {

    List<UniversityEntity> getUniversities();

    UniversityEntity getUniversity(int id);

    void createUniversity(UniversityEntity university);

}
