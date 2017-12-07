package com.netcracker.project.servicefront.impl;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HeadFromUniversityRegistrationServiceImpl extends UserRegistrationServiceImpl {

    @Override
    public void register(UserViewModel user, Map<String, String> parameters) throws RegistrationException {
        super.register(user, parameters);
        if(user.getRole() != UserRole.HEAD_FROM_UNIVERSITY) {
            throw new RegistrationException("Unknown user role - " + user.getRole());
        }
        HeadFromUniversityViewModel headFromUniversity = (HeadFromUniversityViewModel) user;
        FacultyViewModel faculty = new FacultyViewModel();
        faculty.setName(parameters.get("faculty"));
        headFromUniversity.setFaculty(faculty);
        UserEntity userEntity = conversionService.convert(headFromUniversity, UserEntity.class);
        userService.addUser(userEntity);
    }


}
