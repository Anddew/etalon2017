package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.SpecialityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityViewModelToSpecialityEntityConverter implements Converter<SpecialityViewModel, SpecialityEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SpecialityEntity convert(SpecialityViewModel specialityViewModel) {
        SpecialityEntity specialityEntity = new SpecialityEntity();
        String id = specialityViewModel.getId();
        if(id != null) {
            specialityEntity.setId(Integer.parseInt(id));
        }
        String name = specialityViewModel.getName();
        if(name != null) {
            specialityEntity.setName(name);
        }
        specialityEntity.setFaculty(conversionService.convert(specialityViewModel.getFaculty(), FacultyEntity.class));
        return specialityEntity;
    }

}