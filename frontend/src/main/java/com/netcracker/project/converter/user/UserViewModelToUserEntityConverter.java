package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.UserRole;

import org.apache.log4j.Logger;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;

public abstract class UserViewModelToUserEntityConverter {

    private Logger logger = Logger.getLogger(UserViewModelToUserEntityConverter.class);

    public UserEntity convert(UserViewModel userViewModel) {
        UserEntity userEntity = new UserEntity();
        String id = userViewModel.getUserId();
        if(!StringUtils.isEmpty(id)) {
            userEntity.setUserId(Integer.parseInt(id));
        }
        String role = userViewModel.getRole().toString().toUpperCase();
        if(!StringUtils.isEmpty(role)) {
            userEntity.setRole(UserRole.valueOf(role));
        }
        String username = userViewModel.getUsername();
        if(!StringUtils.isEmpty(username)) {
            userEntity.setUsername(username);
        }
        String password = userViewModel.getPassword();
        if(!StringUtils.isEmpty(password)) {
            userEntity.setPassword(password);
        }
        String email = userViewModel.getEmail();
        if(!StringUtils.isEmpty(email)) {
            userEntity.setEmail(email);
        }
        String createTime = userViewModel.getCreateTime();
        if(!StringUtils.isEmpty(createTime)) {
            userEntity.setCreateTime(Timestamp.valueOf(createTime));
        }
        String firstName = userViewModel.getFirstName();
        if(!StringUtils.isEmpty(firstName)) {
            userEntity.setFirstName(firstName);
        }
        String lastName = userViewModel.getLastName();
        if(!StringUtils.isEmpty(lastName)) {
            userEntity.setLastName(lastName);
        }

        logger.debug("Nested conversion UserViewModel to UserEntity completed.");
        return userEntity;
    }

}