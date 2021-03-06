package com.netcracker.project.converter.user;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.PracticeStatus;
import com.netcracker.project.entity.user.student.StudentEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class UserEntityToStudentViewModelConverter extends UserEntityToUserViewModelConverter implements Converter<UserEntity, StudentViewModel> {

    private Logger logger = Logger.getLogger(UserEntityToStudentViewModelConverter.class);

    @Autowired
    private ConversionService conversionService;


    @Override
    public StudentViewModel convert(UserEntity userEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        convert(studentViewModel, userEntity);

        StudentEntity studentEntity = userEntity.getStudentInfo();
        Integer studentId = studentEntity.getStudentId();
        if(studentId != null) {
            studentViewModel.setStudentId(String.valueOf(studentId));
        }
        EducationForm educationForm = studentEntity.getEducationForm();
        if(educationForm != null) {
            studentViewModel.setEducationForm(educationForm.getDescription());
        }
        studentViewModel.setSpeciality(conversionService.convert(studentEntity.getSpeciality(), SpecialityViewModel.class));
        String groupNumber = studentEntity.getGroupNumber();
        if(!StringUtils.isEmpty(groupNumber)) {
            studentViewModel.setGroupNumber(String.valueOf(groupNumber));
        }
        Double avgScore = studentEntity.getAvgScore();
        if(avgScore != null) {
            studentViewModel.setAvgScore(String.valueOf(avgScore));
        }
        HireCondition hireCondition = studentEntity.getHireCondition();
        if(hireCondition != null) {
            studentViewModel.setHireCondition(hireCondition.getDescription());
        }
        PracticeStatus practiceStatus = studentEntity.getPracticeStatus();
        if(practiceStatus != null) {
            studentViewModel.setPracticeStatus(practiceStatus.getDescription());
        }

        logger.debug("Conversion UserEntity to StudentViewModel completed.");
        return studentViewModel;
    }

}