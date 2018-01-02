package com.netcracker.project.converter.practice;

import com.netcracker.project.bean.practice.PracticeViewModel;
import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.practice.PracticeStatus;
import com.netcracker.project.entity.user.student.EducationForm;

import com.netcracker.project.entity.user.student.HireCondition;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.Date;

public class PracticeEntityToPracticeViewModelConverter implements Converter<PracticeEntity, PracticeViewModel> {

    private Logger logger = Logger.getLogger(PracticeEntityToPracticeViewModelConverter.class);

    @Autowired
    private ConversionService conversionService;


    @Override
    public PracticeViewModel convert(PracticeEntity practiceEntity) {
        PracticeViewModel practiceViewModel = new PracticeViewModel();
        Integer id = practiceEntity.getId();
        if(id != null) {
            practiceViewModel.setId(String.valueOf(id));
        }
        PracticeStatus status = practiceEntity.getStatus();
        if(status != null) {
            practiceViewModel.setStatus(status.getDescription());
        }
        practiceViewModel.setFaculty(conversionService.convert(practiceEntity.getFaculty(), FacultyViewModel.class));
        Integer currentStudentRequiredCount = practiceEntity.getStudents().size();
        if(currentStudentRequiredCount != null) {
            practiceViewModel.setCurrentStudentRequiredCount(String.valueOf(currentStudentRequiredCount));
        }
        Integer studentRequiredCount = practiceEntity.getStudentRequiredCount();
        if(studentRequiredCount != null) {
            practiceViewModel.setStudentRequiredCount(String.valueOf(studentRequiredCount));
        }
        Double minAvgScore = practiceEntity.getMinAvgScore();
        if(minAvgScore != null) {
            practiceViewModel.setMinAvgScore(String.valueOf(minAvgScore));
        }
        HireCondition hireCondition = practiceEntity.getHireCondition();
        if(hireCondition != null) {
            practiceViewModel.setHireCondition(hireCondition.getDescription());
        }
        Date dateStart = practiceEntity.getDateStart();
        if(dateStart != null) {
            practiceViewModel.setDateStart(dateStart.toString());
        }
        Date dateEnd = practiceEntity.getDateEnd();
        if(dateEnd != null) {
            practiceViewModel.setDateEnd(dateEnd.toString());
        }
        EducationForm educationForm = practiceEntity.getEducationForm();
        if(educationForm != null) {
            practiceViewModel.setEducationForm(educationForm.getDescription());
        }
        practiceViewModel.setHeadFromCompany(conversionService.convert(practiceEntity.getHeadFromCompany(), HeadFromCompanyViewModel.class));
        practiceViewModel.setHeadFromUniversity(conversionService.convert(practiceEntity.getHeadFromUniversity(), HeadFromUniversityViewModel.class));
        logger.debug("Conversion PracticeEntity to PracticeViewModel completed.");
        return practiceViewModel;
    }

}