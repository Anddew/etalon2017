package com.netcracker.project.converter.user;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToStudentViewModelConverter implements Converter<UserEntity, StudentViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public StudentViewModel convert(UserEntity userEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(String.valueOf(userEntity.getId()));
        studentViewModel.setUsername(userEntity.getUsername());
        studentViewModel.setEmail(userEntity.getEmail());
//        studentViewModel.setCreateTime(userEntity.getCreateTime().toString());
        studentViewModel.setFirstName(userEntity.getFirstName());
        studentViewModel.setLastName(userEntity.getLastName());

        StudentEntity studentEntity = userEntity.getStudentInfo();
        studentViewModel.setEducationForm(studentEntity.getEducationForm().getDescription());
//        studentViewModel.setSpeciality(conversionService.convert(studentEntity.getSpeciality(), SpecialityViewModel.class));
        studentViewModel.setGroupNumber(String.valueOf(studentEntity.getGroupNumber()));
        studentViewModel.setAvgScore(String.valueOf(studentEntity.getAvgScore()));
        studentViewModel.setRequiredJob(studentEntity.getRequiredJob() ? HireCondition.ACCEPT.toString() : HireCondition.DENY.toString());
        studentViewModel.setPracticeStatus(studentEntity.getPracticeStatus().getDescription());

        return studentViewModel;
    }

}