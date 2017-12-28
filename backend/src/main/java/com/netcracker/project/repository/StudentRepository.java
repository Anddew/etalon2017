package com.netcracker.project.repository;

import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
