package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class FacultyViewModelToFacultyEntityConverter implements Converter<FacultyViewModel, FacultyEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public FacultyEntity convert(FacultyViewModel facultyViewModel) {
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setId(Integer.parseInt(facultyViewModel.getId()));
        facultyEntity.setName(facultyViewModel.getName());
        facultyEntity.setUniversity(conversionService.convert(facultyViewModel.getUniversity(), UniversityEntity.class));
        return facultyEntity;
    }

}