package com.netcracker.project.repository;

import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

//    List<StudentEntity> findByEducationForm(EducationForm educationForm);

}
