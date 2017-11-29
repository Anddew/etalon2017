package com.netcracker.project.repository;

import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    Set<FacultyEntity> findFacultyEntitiesByUniversityId(int universityId);

}
