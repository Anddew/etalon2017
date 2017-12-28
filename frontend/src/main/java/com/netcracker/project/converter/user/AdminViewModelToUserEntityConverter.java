package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


public class AdminViewModelToUserEntityConverter extends UserViewModelToUserEntityConverter implements Converter<AdminViewModel, UserEntity> {

    private Logger logger = Logger.getLogger(AdminViewModelToUserEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;


    @Override
    public UserEntity convert(AdminViewModel adminViewModel) {
        UserEntity userEntity = super.convert(adminViewModel);
        logger.debug("Conversion AdminViewModel to UserEntity completed.");
        return userEntity;
    }

}