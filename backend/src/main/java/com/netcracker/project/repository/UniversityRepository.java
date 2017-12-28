package com.netcracker.project.repository;

import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepository extends CrudRepository<UniversityEntity, Integer> {

    UniversityEntity findById(int universityId);

    List<UniversityEntity> findAll();

}
