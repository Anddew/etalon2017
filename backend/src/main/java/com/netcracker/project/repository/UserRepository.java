package com.netcracker.project.repository;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserId(int id);

    UserEntity findByUserIdAndRole(int id, UserRole role);

    @Query("SELECT u FROM UserEntity u WHERE u.studentInfo = (SELECT s FROM StudentEntity s WHERE s.studentId = :id)")
    UserEntity findStudentById(@Param("id") int id);

    /*@Query(value = "SELECT u.*, s.* FROM user u\n" +
            "    JOIN student s ON u.student_id = s.id\n" +
            "    JOIN practice_student ps ON s.id = ps.student_id\n" +
            "    JOIN practice p ON p.id = ps.practice_id\n" +
            "    JOIN user u2 ON p.head_from_company_id = u2.id\n" +
            "    WHERE u2.username =  :username", nativeQuery = true)*/
    @Query(value = "SELECT u.*, s.* FROM user u\n" +
            "    JOIN student s ON u.student_id = s.id\n" +
            "    JOIN practice_student ps ON s.id = ps.student_id\n" +
            "    JOIN practice p ON p.id = ps.practice_id\n" +
            "    WHERE p.id =  :id", nativeQuery = true)
    List<UserEntity> findStudentsFromPractice(@Param("id") int id);

    List<UserEntity> findByRole(UserRole role);

    List<UserEntity> findAll();

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndRole(String username, UserRole role);

}
