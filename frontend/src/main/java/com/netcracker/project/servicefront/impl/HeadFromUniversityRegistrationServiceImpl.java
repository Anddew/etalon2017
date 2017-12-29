package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;

import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class HeadFromUniversityRegistrationServiceImpl extends UserRegistrationServiceImpl {

    private Logger logger = Logger.getLogger(HeadFromUniversityRegistrationServiceImpl.class);

    private static final String FACULTY_PARAMETER_NAME = "faculty";


    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateHeadFromUniversityFields(userParameters)) {
            logger.warn("Head from university user validation failed.");
            throw new RegistrationException("Cannot register head from university user. Input data isn`t correct.");
        }
        super.register(user, userParameters);
        HeadFromUniversityViewModel headFromUniversity = (HeadFromUniversityViewModel) user;
        FacultyViewModel faculty = new FacultyViewModel();
        faculty.setName(userParameters.get(FACULTY_PARAMETER_NAME));
        headFromUniversity.setFaculty(faculty);
        UserEntity userEntity = conversionService.convert(headFromUniversity, UserEntity.class);
        try {
            userService.addUser(userEntity);
        } catch (DataAccessException e) {
            throw new RegistrationException("Cannot add user", e);
        }
        logger.info("Head from university user have been successfully registered.");
    }

}
