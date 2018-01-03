package com.netcracker.project.repository;

import com.netcracker.project.entity.university.SpecialityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialityRepository extends CrudRepository<SpecialityEntity, Integer> {

    List<SpecialityEntity> findAll();

    SpecialityEntity findById(int id);

    List<SpecialityEntity> findSpecialitiesByFacultyId(int id);

}
