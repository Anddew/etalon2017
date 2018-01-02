package com.netcracker.project.repository;

import com.netcracker.project.entity.university.FacultyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    List<FacultyEntity> findAll();

    List<FacultyEntity> findFacultiesByUniversityId(int id);

}
