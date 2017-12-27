package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.PracticeViewModel;
import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.practice.PracticeStatus;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.sql.Date;

public class RequestViewModelToRequestEntityConverter implements Converter<PracticeViewModel, PracticeEntity> {

    private Logger logger = Logger.getLogger(RequestViewModelToRequestEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public PracticeEntity convert(PracticeViewModel practiceViewModel) {
        PracticeEntity practiceEntity = new PracticeEntity();
        String id = practiceViewModel.getId();
        if(!StringUtils.isEmpty(id)) {
            practiceEntity.setId(Integer.parseInt(id));
        }
        String status = practiceViewModel.getStatus();
        if(!StringUtils.isEmpty(status)) {
            practiceEntity.setStatus(PracticeStatus.valueOf(status));
        }
        practiceEntity.setFaculty(conversionService.convert(practiceViewModel.getFaculty(), FacultyEntity.class));
        String studentRequiredCount = practiceViewModel.getStudentRequiredCount();
        if(!StringUtils.isEmpty(studentRequiredCount)) {
            practiceEntity.setStudentRequiredCount(Integer.parseInt(studentRequiredCount));
        }
        String minAvgScore = practiceViewModel.getMinAvgScore();
        if(!StringUtils.isEmpty(minAvgScore)) {
            practiceEntity.setMinAvgScore(Double.parseDouble(minAvgScore));
        }
        String hireCondition = practiceViewModel.getHireCondition();
        if(!StringUtils.isEmpty(hireCondition)) {
            practiceEntity.setHireCondition(HireCondition.valueOf(hireCondition));
        }
        String dateStart = practiceViewModel.getDateStart();
        if(!StringUtils.isEmpty(dateStart)) {
            practiceEntity.setDateStart(Date.valueOf(dateStart));
        }
        String dateEnd = practiceViewModel.getDateEnd();
        if(!StringUtils.isEmpty(dateEnd)) {
            practiceEntity.setDateEnd(Date.valueOf(dateEnd));
        }
        String educationForm = practiceViewModel.getEducationForm();
        if(!StringUtils.isEmpty(educationForm)) {
            practiceEntity.setEducationForm(EducationForm.valueOf(educationForm));
        }
        practiceEntity.setHeadFromCompany(conversionService.convert(practiceViewModel.getHeadFromCompany(), UserEntity.class));
        practiceEntity.setHeadFromUniversity(conversionService.convert(practiceViewModel.getHeadFromUniversity(), UserEntity.class));
        logger.debug("Conversion PracticeViewModel to PracticeEntity completed.");
        return practiceEntity;
    }

}