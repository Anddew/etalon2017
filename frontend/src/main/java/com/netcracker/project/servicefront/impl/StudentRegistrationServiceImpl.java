package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.PracticeStatus;
import com.netcracker.project.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentRegistrationServiceImpl extends UserRegistrationServiceImpl {

    private static final String STUDENT_VALIDATION_ERROR_MESSAGE = "Cannot register student user. Input data isn`t correct.";

    private static final String GROUP_NUMBER_PARAMETER_NAME = "group";

    @Override
    public void register(UserViewModel user, Map<String, String> userParameters) throws RegistrationException {
        if(!validator.validateStudentRegistration(userParameters)) {
            throw new RegistrationException(STUDENT_VALIDATION_ERROR_MESSAGE);
        }
        super.register(user, userParameters);
        StudentViewModel student = (StudentViewModel) user;
        student.setGroupNumber(userParameters.get(GROUP_NUMBER_PARAMETER_NAME));
        student.setPracticeStatus(PracticeStatus.AVAILABLE.getDescription());
        UserEntity userEntity = conversionService.convert(student, UserEntity.class);
        userService.addUser(userEntity);
    }
}
