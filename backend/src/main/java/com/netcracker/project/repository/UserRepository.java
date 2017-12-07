package com.netcracker.project.repository;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findById(int id);

    UserEntity findByEmailAndPassword(String email, String password);

    List<UserEntity> findByRole(UserRole role);

    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

}
