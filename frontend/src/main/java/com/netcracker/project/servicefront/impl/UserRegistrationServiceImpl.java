package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.service.UserService;
import com.netcracker.project.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public abstract class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    protected Validator validator;

    @Autowired
    protected ConversionService conversionService;

    @Autowired
    protected UserService userService;

    @Override
    public void register(UserViewModel user, Map<String, String> parameters) throws RegistrationException {
        System.out.println("password" + parameters.get("password"));
        System.out.println("repeat" + parameters.get("passwordRepeat"));
        System.out.println("validator - " + validator);
        System.out.println("conversionService - " + conversionService);
        boolean isPasswordsSame = validator.validatePassword(parameters.get("password"), parameters.get("passwordRepeat"));
        if(!isPasswordsSame) {
            throw new RegistrationException("Input passwords is not the same");
        }
        user.setUsername(parameters.get("username"));
        user.setPassword(parameters.get("password"));
        user.setEmail(parameters.get("email"));
        user.setFirstName(parameters.get("firstName"));
        user.setLastName(parameters.get("lastName"));
    }

}
