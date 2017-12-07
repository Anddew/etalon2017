package com.netcracker.project.repository;

import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface UniversityRepository extends CrudRepository<UniversityEntity, Integer> {

    UniversityEntity findById(int universityId);

    List<UniversityEntity> findAll();

}
