package com.netcracker.project.repository;

import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    @Override
    StudentEntity findOne(Integer integer);

    List<StudentEntity> findAllByStudentIdIn(List<Integer> ids);

}
