package com.netcracker.project.repository;

import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PracticeRepository extends CrudRepository<PracticeEntity, Integer> {

    List<PracticeEntity> findAll();

    List<PracticeEntity> findAllByHeadFromCompany(UserEntity user);

    List<PracticeEntity> findAllByHeadFromUniversity(UserEntity user);

    @Override
    PracticeEntity findOne(Integer integer);

}
