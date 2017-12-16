package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.PracticeStatus;
import com.netcracker.project.entity.user.student.StudentEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class StudentViewModelToUserEntityConverter extends UserViewModelToUserEntityConverter implements Converter<StudentViewModel, UserEntity> {

    private Logger logger = Logger.getLogger(StudentViewModelToUserEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(StudentViewModel studentViewModel) {
        UserEntity userEntity = super.convert(studentViewModel);

        StudentEntity studentEntity = new StudentEntity();
        String educationForm = studentViewModel.getEducationForm();
        if(educationForm != null) {
            studentEntity.setEducationForm(EducationForm.valueOf(educationForm));
        }
        studentEntity.setSpeciality(conversionService.convert(studentViewModel.getSpeciality(), SpecialityEntity.class));
        String groupNumber = studentViewModel.getGroupNumber();
        if(groupNumber != null) {
            studentEntity.setGroupNumber(Integer.parseInt(groupNumber));
        }
        String avgScore = studentViewModel.getAvgScore();
        if(avgScore != null) {
            studentEntity.setAvgScore(Double.parseDouble(avgScore));
        }
        String requiredJob = studentViewModel.getRequiredJob();
        if(requiredJob != null) {
            studentEntity.setRequiredJob(requiredJob.equals(HireCondition.ACCEPT.toString()));
        }
        String practiceStatus = studentViewModel.getPracticeStatus().toUpperCase();
        if(practiceStatus != null) {
            studentEntity.setPracticeStatus(PracticeStatus.valueOf(practiceStatus));
        }
        userEntity.setStudentInfo(studentEntity);

        logger.debug("Conversion StudentViewModel to UserEntity completed.");
        return userEntity;
    }
}