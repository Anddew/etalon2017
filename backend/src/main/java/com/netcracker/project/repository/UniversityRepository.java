package com.netcracker.project.repository;

import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<UniversityEntity, Integer> {

    UniversityEntity findById(int id);

    UniversityEntity findByName(String name);

}
