package com.netcracker.project.repository;

import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
