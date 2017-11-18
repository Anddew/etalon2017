package com.netcracker.project.repository;

import com.netcracker.project.entity.university.FacultyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    FacultyEntity findById(int id);

    FacultyEntity findByName(String name);

}
