package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.Role;

public class AdminViewModel extends UserViewModel {

    @Override
    public Role getRole() {
        return Role.ADMINISTRATOR;
    }

}
