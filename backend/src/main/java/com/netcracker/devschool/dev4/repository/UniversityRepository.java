package com.netcracker.devschool.dev4.repository;

import com.netcracker.devschool.dev4.entity.university.UniversityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<UniversityEntity, Integer> {

    UniversityEntity findById(int id);

    UniversityEntity findByName(String name);

}
