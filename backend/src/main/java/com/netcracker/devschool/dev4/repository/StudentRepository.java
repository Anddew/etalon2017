package com.netcracker.devschool.dev4.repository;

import com.netcracker.devschool.dev4.entity.user.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    StudentEntity findByGroupNumber(int groupNumber);

//    List<StudentEntity> findByAvgScoreLessThan(double avgScore);

    StudentEntity findByRequiredJob(boolean requiredJob);

}
