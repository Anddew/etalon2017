package com.netcracker.project.service;

import com.netcracker.project.entity.university.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    List<SpecialityEntity> getSpecialities();

    SpecialityEntity getSpeciality(int id);

    void createSpeciality(SpecialityEntity speciality);

    List<SpecialityEntity> getSpecialitiesByFacultyId(int facultyId);

}
