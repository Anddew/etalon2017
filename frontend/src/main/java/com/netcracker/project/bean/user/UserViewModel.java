package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.security.impl.CustomUser;


public abstract class UserViewModel extends CustomUser {

    private String id;
    private String email;
    private String createTime;
    private String firstName;
    private String lastName;

    public UserViewModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract UserRole getRole();

    @Override
    public String toString() {
        return "UserViewModel{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }

}
