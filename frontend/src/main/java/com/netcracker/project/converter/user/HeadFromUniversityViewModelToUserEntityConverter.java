package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class HeadFromUniversityViewModelToUserEntityConverter extends UserViewModelToUserEntityConverter implements Converter<HeadFromUniversityViewModel, UserEntity> {

    private Logger logger = Logger.getLogger(HeadFromUniversityViewModelToUserEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(HeadFromUniversityViewModel headFromUniversityViewModel) {
        UserEntity userEntity = super.convert(headFromUniversityViewModel);
        userEntity.setFaculty(conversionService.convert(headFromUniversityViewModel.getFaculty(), FacultyEntity.class));
        logger.debug("Conversion HeadFromUniversityViewModel to UserEntity completed.");
        return userEntity;
    }

}