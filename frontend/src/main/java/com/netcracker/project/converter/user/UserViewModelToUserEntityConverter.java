package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.UserRole;
import org.apache.log4j.Logger;

import java.sql.Timestamp;

public abstract class UserViewModelToUserEntityConverter {

    private Logger logger = Logger.getLogger(UserViewModelToUserEntityConverter.class.getSimpleName());

    public UserEntity convert(UserViewModel userViewModel) {
        UserEntity userEntity = new UserEntity();
        String id = userViewModel.getUserId();
        if(id != null) {
            userEntity.setUserId(Integer.parseInt(id));
        }
        String role = userViewModel.getRole().toString().toUpperCase();
        if(role != null) {
            userEntity.setRole(UserRole.valueOf(role));
        }
        String username = userViewModel.getUsername();
        if(username != null) {
            userEntity.setUsername(username);
        }
        String password = userViewModel.getPassword();
        if(password != null) {
            userEntity.setPassword(password);
        }
        String email = userViewModel.getEmail();
        if(email != null) {
            userEntity.setEmail(email);
        }
        String createTime = userViewModel.getCreateTime();
        if(createTime != null) {
            userEntity.setCreateTime(Timestamp.valueOf(createTime));
        }
        String firstName = userViewModel.getFirstName();
        if(firstName != null) {
            userEntity.setFirstName(firstName);
        }
        String lastName = userViewModel.getLastName();
        if(lastName != null) {
            userEntity.setLastName(lastName);
        }

        logger.debug("Nested conversion UserViewModel to UserEntity completed.");
        return userEntity;
    }

}