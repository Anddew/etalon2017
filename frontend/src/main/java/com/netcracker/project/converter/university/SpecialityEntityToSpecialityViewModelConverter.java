package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.university.SpecialityEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class SpecialityEntityToSpecialityViewModelConverter implements Converter<SpecialityEntity, SpecialityViewModel> {

    private Logger logger = Logger.getLogger(SpecialityEntityToSpecialityViewModelConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        Integer id = specialityEntity.getId();
        if(id != null) {
            specialityViewModel.setId(String.valueOf(id));
        }
        String name = specialityEntity.getName();
        if(!StringUtils.isEmpty(name)) {
            specialityViewModel.setName(name);
        }
        specialityViewModel.setFaculty(conversionService.convert(specialityEntity.getFaculty(), FacultyViewModel.class));
        logger.debug("Conversion SpecialityEntity to SpecialityViewModel completed.");
        return specialityViewModel;
    }

}