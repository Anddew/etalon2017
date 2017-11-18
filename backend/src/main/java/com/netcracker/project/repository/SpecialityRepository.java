package com.netcracker.project.repository;

import com.netcracker.project.entity.university.SpecialityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<SpecialityEntity, Integer> {

    SpecialityEntity findById(int id);

    SpecialityEntity findByName(String name);

}
