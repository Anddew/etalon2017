package com.netcracker.project.service;

import com.netcracker.project.entity.university.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    List<SpecialityEntity> getAllSpecialities();

    SpecialityEntity getSpecialityById(int facultyId);

    void addSpeciality(SpecialityEntity speciality);

}
