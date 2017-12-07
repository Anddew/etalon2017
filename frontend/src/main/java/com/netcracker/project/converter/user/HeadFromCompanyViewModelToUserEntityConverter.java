package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class HeadFromCompanyViewModelToUserEntityConverter implements Converter<HeadFromCompanyViewModel, UserEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(HeadFromCompanyViewModel headFromCompanyViewModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(headFromCompanyViewModel.getId()));
        userEntity.setRole(UserRole.valueOf(headFromCompanyViewModel.getRole().getDescription()));
        userEntity.setUsername(headFromCompanyViewModel.getUsername());
        userEntity.setPassword(headFromCompanyViewModel.getPassword());
        userEntity.setEmail(headFromCompanyViewModel.getEmail());
        userEntity.setCreateTime(Timestamp.valueOf(headFromCompanyViewModel.getCreateTime()));
        userEntity.setFirstName(headFromCompanyViewModel.getFirstName());
        userEntity.setLastName(headFromCompanyViewModel.getLastName());
        userEntity.setCompany(conversionService.convert(headFromCompanyViewModel.getCompany(), CompanyEntity.class));
        return userEntity;
    }

}