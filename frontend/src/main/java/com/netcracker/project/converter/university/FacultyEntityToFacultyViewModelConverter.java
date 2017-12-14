package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultyEntity, FacultyViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public FacultyViewModel convert(FacultyEntity facultyEntity) {
        FacultyViewModel facultyViewModel = new FacultyViewModel();
        int id = facultyEntity.getId();
        if (id != 0) {
            facultyViewModel.setId(String.valueOf(id));
        }
        String name = facultyEntity.getName();
        if(name != null) {
            facultyViewModel.setName(name);
        }
        facultyViewModel.setUniversity(conversionService.convert(facultyEntity.getUniversity(), UniversityViewModel.class));
        return facultyViewModel;
    }
}