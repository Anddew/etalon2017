package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HeadFromCompanyRegistrationServiceImpl extends UserRegistrationServiceImpl {

    @Override
    public void register(UserViewModel user, Map<String, String> parameters) throws RegistrationException {
        super.register(user, parameters);
        if(user.getRole() != UserRole.HEAD_FROM_COMPANY) {
            throw new RegistrationException("Unknown user role - " + user.getRole());
        }
        HeadFromCompanyViewModel headFromCompany = (HeadFromCompanyViewModel) user;
        CompanyViewModel company = new CompanyViewModel();
        company.setName(parameters.get("company"));
        headFromCompany.setCompany(company);
        UserEntity userEntity = conversionService.convert(headFromCompany, UserEntity.class);
        userService.addUser(userEntity);
    }

}
