package com.netcracker.project.service;

import com.netcracker.project.entity.university.UniversityEntity;

import java.util.List;

public interface UniversityService {

    UniversityEntity getUniversityById(int universityId);

    void addUniversity(UniversityEntity university);

    List<UniversityEntity> getAllUniversities();

}
