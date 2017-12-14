package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HeadFromUniversityRegistrationServiceImpl extends UserRegistrationServiceImpl {

    private static final String HEAD_FROM_UNIVERSITY_VALIDATION_ERROR_MESSAGE = "Cannot register head from university user. Input data isn`t correct.";

    private static final String FACULTY_PARAMETER_NAME = "faculty";

    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateHeadFromUniversityRegistration(userParameters)) {
            throw new RegistrationException(HEAD_FROM_UNIVERSITY_VALIDATION_ERROR_MESSAGE);
        }
        super.register(user, userParameters);
        HeadFromUniversityViewModel headFromUniversity = (HeadFromUniversityViewModel) user;
        FacultyViewModel faculty = new FacultyViewModel();
        faculty.setName(userParameters.get(FACULTY_PARAMETER_NAME));
        headFromUniversity.setFaculty(faculty);
        UserEntity userEntity = conversionService.convert(headFromUniversity, UserEntity.class);
        userService.addUser(userEntity);
    }

}
