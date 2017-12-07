package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.RequestViewModel;
import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.entity.practice.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        RequestViewModel requestViewModel = new RequestViewModel();
        requestViewModel.setId(String.valueOf(requestEntity.getId()));
        requestViewModel.setStatus(requestEntity.getStatus().getDescription());
        requestViewModel.setFaculty(conversionService.convert(requestEntity.getFaculty(), FacultyViewModel.class));
        requestViewModel.setStudentRequiredCount(String.valueOf(requestEntity.getStudentRequiredCount()));
        requestViewModel.setMinAvgScore(String.valueOf(requestEntity.getMinAvgScore()));
        requestViewModel.setHireCondition(requestEntity.getHireCondition().getDescription());
        requestViewModel.setDateStart(requestEntity.getDateStart().toString());
        requestViewModel.setDateEnd(requestEntity.getDateEnd().toString());
        requestViewModel.setEducationForm(requestEntity.getEducationForm().toString());
        return requestViewModel;
    }
}