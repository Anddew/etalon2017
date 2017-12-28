package com.netcracker.project.repository;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PracticeRepository extends CrudRepository<PracticeEntity, Integer> {

    List<PracticeEntity> findAll();

    List<PracticeEntity> findAllByHeadFromCompany(UserEntity user);

    List<PracticeEntity> findAllByHeadFromUniversity(UserEntity user);

}
