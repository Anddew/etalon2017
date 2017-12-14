package com.netcracker.project.converter.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToHeadFromCompanyViewModelConverter extends UserEntityToUserViewModelConverter implements Converter<UserEntity, HeadFromCompanyViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public HeadFromCompanyViewModel convert(UserEntity userEntity) {
        HeadFromCompanyViewModel headFromCompanyViewModel = new HeadFromCompanyViewModel();
        setUserFields(headFromCompanyViewModel, userEntity);
        headFromCompanyViewModel.setCompany(conversionService.convert(userEntity.getCompany(), CompanyViewModel.class));
        return headFromCompanyViewModel;
    }

}