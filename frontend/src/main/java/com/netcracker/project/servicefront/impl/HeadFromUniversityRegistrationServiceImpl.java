package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;

import com.netcracker.project.service.FacultyService;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service
public class HeadFromUniversityRegistrationServiceImpl extends UserRegistrationServiceImpl {

    private Logger logger = Logger.getLogger(HeadFromUniversityRegistrationServiceImpl.class);

    @Autowired
    private FacultyService facultyService;

    @Transactional
    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        super.register(user, userParameters);
        HeadFromUniversityViewModel headFromUniversity = (HeadFromUniversityViewModel) user;
        UserEntity userEntity = conversionService.convert(headFromUniversity, UserEntity.class);
        FacultyEntity faculty = facultyService.getFaculty(Integer.valueOf(userParameters.get("facultyId")));
        userEntity.setFaculty(faculty);
        try {
            userService.addUser(userEntity);
        } catch (DataAccessException e) {
            throw new RegistrationException("Cannot add user", e);
        }
        logger.info("Head from university user have been successfully registered.");
    }

}
