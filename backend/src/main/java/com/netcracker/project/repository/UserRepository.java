package com.netcracker.project.repository;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserId(int id);

    @Query("SELECT u FROM UserEntity u WHERE u.studentInfo = (SELECT s FROM StudentEntity s WHERE s.studentId = :id)")
    UserEntity findStudentById(@Param("id") int id);

    @Query(value = "SELECT u.*, s.* FROM user u\n" +
            "    JOIN student s ON u.student_id = s.id\n" +
            "    JOIN practice_student ps ON s.id = ps.student_id\n" +
            "    JOIN practice p ON p.id = ps.practice_id\n" +
            "    WHERE p.id =  :id", nativeQuery = true)
    List<UserEntity> findStudentsFromPractice(@Param("id") int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE StudentEntity SET avgScore = :avgScore, educationForm = :educationForm, hireCondition = :hireCondition WHERE studentId = :id")
    void saveStudentDetails(@Param("id") int id, @Param("avgScore") double avgScore, @Param("educationForm") EducationForm educationForm, @Param("hireCondition") HireCondition hireCondition);

    List<UserEntity> findByRole(UserRole role);

    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndRole(String username, UserRole role);

}
