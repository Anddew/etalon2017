package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class AdminViewModelToUserEntityConverter implements Converter<AdminViewModel, UserEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(AdminViewModel adminViewModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(adminViewModel.getId()));
        userEntity.setRole(UserRole.valueOf(adminViewModel.getRole().getDescription()));
        userEntity.setUsername(adminViewModel.getUsername());
        userEntity.setPassword(adminViewModel.getPassword());
        userEntity.setEmail(adminViewModel.getEmail());
        userEntity.setCreateTime(Timestamp.valueOf(adminViewModel.getCreateTime()));
        userEntity.setFirstName(adminViewModel.getFirstName());
        userEntity.setLastName(adminViewModel.getLastName());
        return userEntity;
    }
}