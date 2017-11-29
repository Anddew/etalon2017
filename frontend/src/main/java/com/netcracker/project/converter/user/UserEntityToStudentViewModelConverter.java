package com.netcracker.project.converter.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToStudentViewModelConverter implements Converter<UserEntity, StudentViewModel> {

    private static final String REQUIRED_JOB_CONDITION = "Yes";
    private static final String NOT_REQUIRED_JOB_CONDITION = "No";

    @Autowired
    private ConversionService conversionService;

    @Override
    public StudentViewModel convert(UserEntity userEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(String.valueOf(userEntity.getId()));
        studentViewModel.setUsername(userEntity.getUsername());
        studentViewModel.setEmail(userEntity.getEmail());
        studentViewModel.setCreateTime(userEntity.getCreateTime().toString());
        studentViewModel.setFirstName(userEntity.getFirstName());
        studentViewModel.setLastName(userEntity.getLastName());

        StudentEntity studentEntity = userEntity.getStudentInfo();
        studentViewModel.setEducationForm(studentEntity.getEducationForm().toString());
        studentViewModel.setSpeciality(conversionService.convert(studentEntity.getSpeciality(), SpecialityViewModel.class));
        studentViewModel.setGroupNumber(String.valueOf(studentEntity.getGroupNumber()));
        studentViewModel.setAvgScore(String.valueOf(studentEntity.getAvgScore()));
        studentViewModel.setRequiredJob(studentEntity.getRequiredJob() ? REQUIRED_JOB_CONDITION : NOT_REQUIRED_JOB_CONDITION);
        studentViewModel.setPracticeStatus(studentEntity.getPracticeStatus().toString());

        return studentViewModel;
    }
}