package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.UserRole;

import java.util.Objects;

public class AdminViewModel extends UserViewModel {

    private static final long serialVersionUID = -5638812931455752574L;


    @Override
    public UserRole getRole() {
        return UserRole.ADMINISTRATOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return "AdminViewModel{} " + super.toString();
    }

}
