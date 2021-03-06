package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.security.Encrypter;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.service.UserService;
import com.netcracker.project.validation.UserValidator;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import java.util.Map;


@Component
public abstract class UserRegistrationServiceImpl implements UserRegistrationService {

    private Logger logger = Logger.getLogger(UserRegistrationServiceImpl.class);

    private static final String EMAIL_PARAMETER_NAME = "email";
    private static final String FIRST_NAME_PARAMETER_NAME = "firstname";
    private static final String LAST_NAME_PARAMETER_NAME = "lastname";
    private static final String USERNAME_PARAMETER_NAME = "username";
    private static final String PASSWORD_PARAMETER_NAME = "password";


    @Autowired
    protected UserValidator validator;

    @Autowired
    protected ConversionService conversionService;

    @Autowired
    protected UserService userService;

    @Autowired
    private Encrypter encrypter;


    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateUserFields(userParameters)) {
            logger.warn("User fields validation failed.");
            throw new RegistrationException("Cannot register user. Input data isn`t correct.");
        }
        user.setUsername(userParameters.get(USERNAME_PARAMETER_NAME));
        user.setPassword(encrypter.encrypt(userParameters.get(PASSWORD_PARAMETER_NAME)));
        user.setCreateTime(new Timestamp(System.currentTimeMillis()).toString());
        user.setEmail(userParameters.get(EMAIL_PARAMETER_NAME));
        user.setFirstName(userParameters.get(FIRST_NAME_PARAMETER_NAME));
        user.setLastName(userParameters.get(LAST_NAME_PARAMETER_NAME));
        logger.info("User parameters successfully added.");
    }

}
