package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.SpecialityEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class SpecialityViewModelToSpecialityEntityConverter implements Converter<SpecialityViewModel, SpecialityEntity> {

    private Logger logger = Logger.getLogger(SpecialityEntityToSpecialityViewModelConverter.class);

    @Autowired
    private ConversionService conversionService;


    @Override
    public SpecialityEntity convert(SpecialityViewModel specialityViewModel) {
        SpecialityEntity specialityEntity = new SpecialityEntity();
        String id = specialityViewModel.getId();
        if(!StringUtils.isEmpty(id)) {
            specialityEntity.setId(Integer.parseInt(id));
        }
        String name = specialityViewModel.getName();
        if(!StringUtils.isEmpty(name)) {
            specialityEntity.setName(name);
        }
        specialityEntity.setFaculty(conversionService.convert(specialityViewModel.getFaculty(), FacultyEntity.class));
        logger.debug("Conversion SpecialityViewModel to SpecialityEntity completed.");
        return specialityEntity;
    }

}