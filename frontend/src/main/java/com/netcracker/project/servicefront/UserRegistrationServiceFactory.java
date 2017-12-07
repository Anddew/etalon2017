package com.netcracker.project.servicefront;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.servicefront.impl.HeadFromCompanyRegistrationServiceImpl;
import com.netcracker.project.servicefront.impl.HeadFromUniversityRegistrationServiceImpl;
import com.netcracker.project.servicefront.impl.StudentRegistrationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationServiceFactory {

    private static final Map<UserRole, UserRegistrationService> registrationService = new HashMap<>();

    static {
        registrationService.put(UserRole.STUDENT, new StudentRegistrationServiceImpl());
        registrationService.put(UserRole.HEAD_FROM_UNIVERSITY, new HeadFromUniversityRegistrationServiceImpl());
        registrationService.put(UserRole.HEAD_FROM_COMPANY, new HeadFromCompanyRegistrationServiceImpl());
    }

    private UserRegistrationServiceFactory() {
    }

    public static UserRegistrationService getRegistrationService(UserRole role) {
        return registrationService.get(role);
    }

}
