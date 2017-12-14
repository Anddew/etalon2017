package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.security.Encrypter;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.service.UserService;
import com.netcracker.project.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Map;

@Component
public abstract class UserRegistrationServiceImpl implements UserRegistrationService {

    private static final String EMAIL_PARAMETER_NAME = "email";
    private static final String FIRST_NAME_PARAMETER_NAME = "firstname";
    private static final String LAST_NAME_PARAMETER_NAME = "lastname";
    private static final String USERNAME_PARAMETER_NAME = "username";
    private static final String PASSWORD_PARAMETER_NAME = "password";

    private static final String USER_VALIDATION_ERROR_MESSAGE = "Cannot register user. Input data isn`t correct.";

    @Autowired
    protected Validator validator;

    @Autowired
    protected ConversionService conversionService;

    @Autowired
    protected UserService userService;

    @Autowired
    private Encrypter encrypter;

    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateUserRegistration(userParameters)) {
            throw new RegistrationException(USER_VALIDATION_ERROR_MESSAGE);
        }
        user.setUsername(userParameters.get(USERNAME_PARAMETER_NAME));
        user.setPassword(encrypter.encrypt(userParameters.get(PASSWORD_PARAMETER_NAME)));
        user.setCreateTime(new Timestamp(System.currentTimeMillis()).toString());
        user.setEmail(userParameters.get(EMAIL_PARAMETER_NAME));
        user.setFirstName(userParameters.get(FIRST_NAME_PARAMETER_NAME));
        user.setLastName(userParameters.get(LAST_NAME_PARAMETER_NAME));
    }



}
