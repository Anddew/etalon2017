package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.entity.user.UserEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


public class HeadFromCompanyViewModelToUserEntityConverter extends UserViewModelToUserEntityConverter implements Converter<HeadFromCompanyViewModel, UserEntity> {

    private Logger logger = Logger.getLogger(HeadFromCompanyViewModelToUserEntityConverter.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;


    @Override
    public UserEntity convert(HeadFromCompanyViewModel headFromCompanyViewModel) {
        UserEntity userEntity = super.convert(headFromCompanyViewModel);
        userEntity.setCompany(conversionService.convert(headFromCompanyViewModel.getCompany(), CompanyEntity.class));
        logger.debug("Conversion HeadFromCompanyViewModel to UserEntity completed.");
        return userEntity;
    }

}