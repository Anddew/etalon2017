package com.netcracker.project.repository;

import com.netcracker.project.entity.user.Role;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmailAndPassword(String email, String password);

    Set<UserEntity> findByRole(Role role);

    Set<UserEntity> findAll();

}
