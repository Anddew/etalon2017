package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentRegistrationServiceImpl extends UserRegistrationServiceImpl {

    @Override
    public void register(UserViewModel user, Map<String, String> parameters) throws RegistrationException {
        super.register(user, parameters);
        if(user.getRole() != UserRole.STUDENT) {
            throw new RegistrationException("Unknown user role - " + user.getRole());
        }
        StudentViewModel student = (StudentViewModel) user;
        student.setGroupNumber(parameters.get("groupNumber"));
        UserEntity userEntity = conversionService.convert(student, UserEntity.class);
        userService.addUser(userEntity);
    }
}
