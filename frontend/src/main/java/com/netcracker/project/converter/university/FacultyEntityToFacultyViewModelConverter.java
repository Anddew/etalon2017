package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultyEntity, FacultyViewModel> {

    private Logger logger = Logger.getLogger(FacultyEntityToFacultyViewModelConverter.class);

    @Autowired
    private ConversionService conversionService;


    @Override
    public FacultyViewModel convert(FacultyEntity facultyEntity) {
        FacultyViewModel facultyViewModel = new FacultyViewModel();
        Integer id = facultyEntity.getId();
        if (id != null) {
            facultyViewModel.setId(String.valueOf(id));
        }
        String name = facultyEntity.getName();
        if(!StringUtils.isEmpty(name)) {
            facultyViewModel.setName(name);
        }
        facultyViewModel.setUniversity(conversionService.convert(facultyEntity.getUniversity(), UniversityViewModel.class));
        logger.debug("Conversion FacultyEntity to FacultyViewModel completed.");
        return facultyViewModel;
    }

}