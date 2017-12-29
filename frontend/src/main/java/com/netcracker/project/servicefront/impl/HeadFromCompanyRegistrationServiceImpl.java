package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;

import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class HeadFromCompanyRegistrationServiceImpl extends UserRegistrationServiceImpl {

    private Logger logger = Logger.getLogger(HeadFromCompanyRegistrationServiceImpl.class);

    private static final String COMPANY_PARAMETER_NAME = "company";


    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateHeadFromCompanyFields(userParameters)) {
            logger.warn("Head from company user validation failed.");
            throw new RegistrationException("Cannot register head from company user. Input data isn`t correct.");
        }
        super.register(user, userParameters);
        HeadFromCompanyViewModel headFromCompany = (HeadFromCompanyViewModel) user;
        CompanyViewModel company = new CompanyViewModel();
        company.setName(userParameters.get(COMPANY_PARAMETER_NAME));
        headFromCompany.setCompany(company);
        UserEntity userEntity = conversionService.convert(headFromCompany, UserEntity.class);
        try {
            userService.addUser(userEntity);
        } catch (DataAccessException e) {
            throw new RegistrationException("Cannot add user", e);
        }
        logger.info("Head from company user have been successfully registered.");
    }

}
