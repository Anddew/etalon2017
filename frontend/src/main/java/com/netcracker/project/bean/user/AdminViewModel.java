package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.UserRole;

public class AdminViewModel extends UserViewModel {

    @Override
    public UserRole getRole() {
        return UserRole.ADMINISTRATOR;
    }

    @Override
    public String toString() {
        return "AdminViewModel{} " + super.toString();
    }

}
