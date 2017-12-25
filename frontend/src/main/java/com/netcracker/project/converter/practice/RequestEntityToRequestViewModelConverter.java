package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.RequestViewModel;
import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.entity.practice.RequestEntity;
import com.netcracker.project.entity.practice.RequestStatus;
import com.netcracker.project.entity.user.student.EducationForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.Date;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity, RequestViewModel> {

    private Logger logger = Logger.getLogger(RequestEntityToRequestViewModelConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        RequestViewModel requestViewModel = new RequestViewModel();
        Integer id = requestEntity.getId();
        if(id != null) {
            requestViewModel.setId(String.valueOf(id));
        }
        RequestStatus status = requestEntity.getStatus();
        if(status != null) {
            requestViewModel.setStatus(status.getDescription());
        }
        requestViewModel.setFaculty(conversionService.convert(requestEntity.getFaculty(), FacultyViewModel.class));
        Integer studentRequiredCount = requestEntity.getStudentRequiredCount();
        if(studentRequiredCount != null) {
            requestViewModel.setStudentRequiredCount(String.valueOf(studentRequiredCount));
        }
        Double minAvgScore = requestEntity.getMinAvgScore();
        if(minAvgScore != null) {
            requestViewModel.setMinAvgScore(String.valueOf(minAvgScore));
        }
        String hireCondition = requestEntity.getHireCondition().getDescription();
        if(!StringUtils.isEmpty(hireCondition)) {
            requestViewModel.setHireCondition(hireCondition);
        }
        Date dateStart = requestEntity.getDateStart();
        if(dateStart != null) {
            requestViewModel.setDateStart(dateStart.toString());
        }
        Date dateEnd = requestEntity.getDateEnd();
        if(dateEnd != null) {
            requestViewModel.setDateEnd(dateEnd.toString());
        }
        EducationForm educationForm = requestEntity.getEducationForm();
        if(educationForm != null) {
            requestViewModel.setEducationForm(educationForm.toString());
        }
        logger.debug("Conversion RequestEntity to RequestViewModel completed.");
        return requestViewModel;
    }
}