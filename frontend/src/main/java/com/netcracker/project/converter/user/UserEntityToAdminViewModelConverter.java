package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToAdminViewModelConverter extends UserEntityToUserViewModelConverter implements Converter<UserEntity, AdminViewModel> {

    private Logger logger = Logger.getLogger(UserEntityToAdminViewModelConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;


    @Override
    public AdminViewModel convert(UserEntity userEntity) {
        AdminViewModel adminViewModel = new AdminViewModel();
        convert(adminViewModel, userEntity);
        logger.debug("Conversion UserEntity to AdminViewModel completed.");
        return adminViewModel;
    }

}