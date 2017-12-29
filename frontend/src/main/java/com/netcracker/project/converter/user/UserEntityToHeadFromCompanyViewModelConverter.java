package com.netcracker.project.converter.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.entity.user.UserEntity;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


public class UserEntityToHeadFromCompanyViewModelConverter extends UserEntityToUserViewModelConverter implements Converter<UserEntity, HeadFromCompanyViewModel> {

    private Logger logger = Logger.getLogger(UserEntityToHeadFromCompanyViewModelConverter.class);

    @Autowired
    private ConversionService conversionService;


    @Override
    public HeadFromCompanyViewModel convert(UserEntity userEntity) {
        HeadFromCompanyViewModel headFromCompanyViewModel = new HeadFromCompanyViewModel();
        convert(headFromCompanyViewModel, userEntity);
        headFromCompanyViewModel.setCompany(conversionService.convert(userEntity.getCompany(), CompanyViewModel.class));
        logger.debug("Conversion UserEntity to HeadFromCompanyViewModel completed.");
        return headFromCompanyViewModel;
    }

}