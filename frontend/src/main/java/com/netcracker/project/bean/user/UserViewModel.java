package com.netcracker.project.bean.user;

import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.security.impl.CustomUser;

import java.util.Objects;


public abstract class UserViewModel extends CustomUser {

    private static final long serialVersionUID = -7262052903432757865L;

    private String userId;
    private String email;
    private String createTime;
    private String firstName;
    private String lastName;

    public UserViewModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserViewModel that = (UserViewModel) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, email, createTime, firstName, lastName);
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }

}
