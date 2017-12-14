package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.RequestViewModel;
import com.netcracker.project.entity.practice.RequestEntity;
import com.netcracker.project.entity.practice.RequestStatus;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Date;

public class RequestViewModelToRequestEntityConverter implements Converter<RequestViewModel, RequestEntity> {


    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestEntity convert(RequestViewModel requestViewModel) {
        RequestEntity requestEntity = new RequestEntity();
        String id = requestViewModel.getId();
        if(id != null) {
            requestEntity.setId(Integer.parseInt(id));
        }
        String status = requestViewModel.getStatus();
        if(status != null) {
            requestEntity.setStatus(RequestStatus.valueOf(status));
        }
        requestEntity.setFaculty(conversionService.convert(requestViewModel.getFaculty(), FacultyEntity.class));
        String studentRequiredCount = requestViewModel.getStudentRequiredCount();
        if(studentRequiredCount != null) {
            requestEntity.setStudentRequiredCount(Integer.parseInt(studentRequiredCount));
        }
        String minAvgScore = requestViewModel.getMinAvgScore();
        if(minAvgScore != null) {
            requestEntity.setMinAvgScore(Double.parseDouble(minAvgScore));
        }
        String hireCondition = requestViewModel.getHireCondition();
        if(hireCondition != null) {
            requestEntity.setHireCondition(HireCondition.valueOf(hireCondition));
        }
        String dateStart = requestViewModel.getDateStart();
        if(dateStart != null) {
            requestEntity.setDateStart(Date.valueOf(dateStart));
        }
        String dateEnd = requestViewModel.getDateEnd();
        if(dateEnd != null) {
            requestEntity.setDateEnd(Date.valueOf(dateEnd));
        }
        String educationForm = requestViewModel.getEducationForm();
        if(educationForm != null) {
            requestEntity.setEducationForm(EducationForm.valueOf(educationForm));
        }
        return requestEntity;
    }

}