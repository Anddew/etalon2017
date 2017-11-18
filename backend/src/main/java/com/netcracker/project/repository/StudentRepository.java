package com.netcracker.project.repository;

import com.netcracker.project.entity.user.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    StudentEntity findByGroupNumber(int groupNumber);

//    List<StudentEntity> findByAvgScoreLessThan(double avgScore);

    StudentEntity findByRequiredJob(boolean requiredJob);

}
