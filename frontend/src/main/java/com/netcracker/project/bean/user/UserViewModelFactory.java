package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserViewModelFactory {

    private static final Map<UserRole, UserViewModel> viewModels = new HashMap<>();

    static {
        viewModels.put(UserRole.ADMINISTRATOR, new AdminViewModel());
        viewModels.put(UserRole.HEAD_FROM_COMPANY, new HeadFromCompanyViewModel());
        viewModels.put(UserRole.HEAD_FROM_UNIVERSITY, new HeadFromUniversityViewModel());
        viewModels. put(UserRole.STUDENT, new StudentViewModel());
    }

    private UserViewModelFactory() {

    }

    public static UserViewModel getViewModel(UserRole role) {
        return viewModels.get(role);
    }

}
