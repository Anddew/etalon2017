package com.netcracker.project.repository;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserId(int id);

    UserEntity findByUserIdAndRole(int id, UserRole role);

    @Query("SELECT u FROM UserEntity u WHERE u.studentInfo = (SELECT s FROM StudentEntity s WHERE s.studentId = :id)")
    UserEntity findStudentById(@Param("id") int id);

    UserEntity findByEmailAndPassword(String email, String password);

    List<UserEntity> findByRole(UserRole role);

    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndRole(String username, UserRole role);

}
