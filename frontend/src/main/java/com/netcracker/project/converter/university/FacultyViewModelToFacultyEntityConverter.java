package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class FacultyViewModelToFacultyEntityConverter implements Converter<FacultyViewModel, FacultyEntity> {

    private Logger logger = Logger.getLogger(FacultyViewModelToFacultyEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public FacultyEntity convert(FacultyViewModel facultyViewModel) {
        FacultyEntity facultyEntity = new FacultyEntity();
        String id = facultyViewModel.getId();
        if(id != null) {
            facultyEntity.setId(Integer.parseInt(id));
        }
        String name = facultyViewModel.getName();
        if(!StringUtils.isEmpty(name)) {
            facultyEntity.setName(name);
        }
        facultyEntity.setUniversity(conversionService.convert(facultyViewModel.getUniversity(), UniversityEntity.class));
        logger.debug("Conversion FacultyViewModel to FacultyEntity completed.");
        return facultyEntity;
    }

}