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

import static com.netcracker.project.entity.user.student.HireCondition.ACCEPT;

public class RequestViewModelToRequestEntityConverter implements Converter<RequestViewModel, RequestEntity> {


    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestEntity convert(RequestViewModel requestViewModel) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setId(Integer.parseInt(requestViewModel.getId()));
        requestEntity.setStatus(RequestStatus.valueOf(requestViewModel.getStatus()));
        requestEntity.setFaculty(conversionService.convert(requestViewModel.getFaculty(), FacultyEntity.class));
        requestEntity.setStudentRequiredCount(Integer.parseInt(requestViewModel.getStudentRequiredCount()));
        requestEntity.setMinAvgScore(Double.parseDouble(requestViewModel.getMinAvgScore()));
        requestEntity.setHireCondition(HireCondition.valueOf(requestViewModel.getHireCondition()));
        requestEntity.setDateStart(Date.valueOf(requestViewModel.getDateStart()));
        requestEntity.setDateEnd(Date.valueOf(requestViewModel.getDateEnd()));
        requestEntity.setEducationForm(EducationForm.valueOf(requestViewModel.getEducationForm()));
        return requestEntity;
    }

}