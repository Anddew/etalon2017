package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class AdminViewModelToUserEntityConverter extends UserViewModelToUserEntityConverter implements Converter<AdminViewModel, UserEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(AdminViewModel adminViewModel) {
        UserEntity userEntity = super.convert(adminViewModel);
        return userEntity;
    }

}