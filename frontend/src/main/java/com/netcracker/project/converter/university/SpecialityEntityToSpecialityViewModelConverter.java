package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.university.SpecialityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityEntityToSpecialityViewModelConverter implements Converter<SpecialityEntity, SpecialityViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        int id = specialityEntity.getId();
        if(id != 0) {
            specialityViewModel.setId(String.valueOf(id));
        }
        String name = specialityEntity.getName();
        if(name != null) {
            specialityViewModel.setName(name);
        }
        specialityViewModel.setFaculty(conversionService.convert(specialityEntity.getFaculty(), FacultyViewModel.class));
        return specialityViewModel;
    }

}