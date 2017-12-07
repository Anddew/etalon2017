package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToAdminViewModelConverter implements Converter<UserEntity, AdminViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AdminViewModel convert(UserEntity userEntity) {
        AdminViewModel adminViewModel = new AdminViewModel();
        adminViewModel.setId(String.valueOf(userEntity.getId()));
        adminViewModel.setUsername(userEntity.getUsername());
        adminViewModel.setEmail(userEntity.getEmail());
//        adminViewModel.setCreateTime(userEntity.getCreateTime().toString());
        adminViewModel.setFirstName(userEntity.getFirstName());
        adminViewModel.setLastName(userEntity.getLastName());
        return adminViewModel;
    }
}