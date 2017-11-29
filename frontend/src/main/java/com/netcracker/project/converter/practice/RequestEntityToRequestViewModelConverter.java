package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.RequestViewModel;
import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.practice.RequestEntity;
import com.netcracker.project.entity.university.FacultyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {

    private static final String ACCEPT_CONDITION = "Yes";
    private static final String DENY_CONDITION = "No";

    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        RequestViewModel requestViewModel = new RequestViewModel();
        requestViewModel.setId(String.valueOf(requestEntity.getId()));
        requestViewModel.setStatus(requestEntity.getStatus().toString());
        requestViewModel.setFaculty(conversionService.convert(requestEntity.getFaculty(), FacultyViewModel.class));
        requestViewModel.setStudentRequiredCount(String.valueOf(requestEntity.getStudentRequiredCount()));
        requestViewModel.setMinAvgScore(String.valueOf(requestEntity.getMinAvgScore()));
        requestViewModel.setProvideHire(requestEntity.getProvideHire() ? ACCEPT_CONDITION : DENY_CONDITION);
        requestViewModel.setDateStart(requestEntity.getDateStart().toString());
        requestViewModel.setDateEnd(requestEntity.getDateEnd().toString());
        requestViewModel.setEducationForm(requestEntity.getEducationForm().toString());
        return requestViewModel;
    }
}