package com.netcracker.project.servicefront.impl;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.servicefront.UserRegistrationService;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class UserRegistrationServiceFactory {

    private Map<UserRole, UserRegistrationService> registrationServices;


    public void setRegistrationServices(Map<UserRole, UserRegistrationService> registrationServices) {
        this.registrationServices = registrationServices;
    }

    public UserRegistrationServiceFactory() {
    }

    public UserRegistrationService getRegistrationService(UserRole role) {
        return registrationServices.get(role);
    }

}
