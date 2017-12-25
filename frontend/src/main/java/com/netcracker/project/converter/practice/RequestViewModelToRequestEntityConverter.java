package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.RequestViewModel;
import com.netcracker.project.entity.practice.RequestEntity;
import com.netcracker.project.entity.practice.RequestStatus;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.sql.Date;

public class RequestViewModelToRequestEntityConverter implements Converter<RequestViewModel, RequestEntity> {

    private Logger logger = Logger.getLogger(RequestViewModelToRequestEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestEntity convert(RequestViewModel requestViewModel) {
        RequestEntity requestEntity = new RequestEntity();
        String id = requestViewModel.getId();
        if(!StringUtils.isEmpty(id)) {
            requestEntity.setId(Integer.parseInt(id));
        }
        String status = requestViewModel.getStatus();
        if(!StringUtils.isEmpty(status)) {
            requestEntity.setStatus(RequestStatus.valueOf(status));
        }
        requestEntity.setFaculty(conversionService.convert(requestViewModel.getFaculty(), FacultyEntity.class));
        String studentRequiredCount = requestViewModel.getStudentRequiredCount();
        if(!StringUtils.isEmpty(studentRequiredCount)) {
            requestEntity.setStudentRequiredCount(Integer.parseInt(studentRequiredCount));
        }
        String minAvgScore = requestViewModel.getMinAvgScore();
        if(!StringUtils.isEmpty(minAvgScore)) {
            requestEntity.setMinAvgScore(Double.parseDouble(minAvgScore));
        }
        String hireCondition = requestViewModel.getHireCondition();
        if(!StringUtils.isEmpty(hireCondition)) {
            requestEntity.setHireCondition(HireCondition.valueOf(hireCondition));
        }
        String dateStart = requestViewModel.getDateStart();
        if(!StringUtils.isEmpty(dateStart)) {
            requestEntity.setDateStart(Date.valueOf(dateStart));
        }
        String dateEnd = requestViewModel.getDateEnd();
        if(!StringUtils.isEmpty(dateEnd)) {
            requestEntity.setDateEnd(Date.valueOf(dateEnd));
        }
        String educationForm = requestViewModel.getEducationForm();
        if(!StringUtils.isEmpty(educationForm)) {
            requestEntity.setEducationForm(EducationForm.valueOf(educationForm));
        }
        logger.debug("Conversion RequestViewModel to RequestEntity completed.");
        return requestEntity;
    }

}