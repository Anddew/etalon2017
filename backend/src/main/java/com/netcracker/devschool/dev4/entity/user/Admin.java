package com.netcracker.devschool.dev4.entity.user;

public class Admin extends User {

    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

}
