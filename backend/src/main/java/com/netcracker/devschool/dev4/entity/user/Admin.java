package com.netcracker.devschool.dev4.entity.user.admin;

import com.netcracker.devschool.dev4.entity.user.Role;
import com.netcracker.devschool.dev4.entity.user.User;

public class Admin extends User {

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

}
