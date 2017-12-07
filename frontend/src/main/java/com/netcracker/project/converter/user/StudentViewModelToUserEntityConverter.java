package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.PracticeStatus;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class StudentViewModelToUserEntityConverter implements Converter<StudentViewModel, UserEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(StudentViewModel studentViewModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(studentViewModel.getId()));
        userEntity.setRole(UserRole.valueOf(studentViewModel.getRole().getDescription()));
        userEntity.setUsername(studentViewModel.getUsername());
        userEntity.setPassword(studentViewModel.getPassword());
        userEntity.setEmail(studentViewModel.getEmail());
        userEntity.setCreateTime(Timestamp.valueOf(studentViewModel.getCreateTime()));
        userEntity.setFirstName(studentViewModel.getFirstName());
        userEntity.setLastName(studentViewModel.getLastName());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setEducationForm(EducationForm.valueOf(studentViewModel.getEducationForm()));
        studentEntity.setSpeciality(conversionService.convert(studentViewModel.getSpeciality(), SpecialityEntity.class));
        studentEntity.setGroupNumber(Integer.parseInt(studentViewModel.getGroupNumber()));
        studentEntity.setAvgScore(Double.parseDouble(studentViewModel.getAvgScore()));
        studentEntity.setRequiredJob(studentViewModel.getRequiredJob().equals(HireCondition.ACCEPT.toString()));
        studentEntity.setPracticeStatus(PracticeStatus.valueOf(studentViewModel.getPracticeStatus()));
        userEntity.setStudentInfo(studentEntity);

        return userEntity;
    }
}