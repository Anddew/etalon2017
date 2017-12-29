package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;

import org.apache.log4j.Logger;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;


public abstract class UserEntityToUserViewModelConverter {

    private Logger logger = Logger.getLogger(UserEntityToUserViewModelConverter.class);


    public void convert(UserViewModel userViewModel, UserEntity userEntity) {
        Integer id = userEntity.getUserId();
        if(id != null) {
            userViewModel.setUserId(String.valueOf(id));
        }
        String username = userEntity.getUsername();
        if(!StringUtils.isEmpty(username)) {
            userViewModel.setUsername(username);
        }
        String email = userEntity.getEmail();
        if(!StringUtils.isEmpty(email)) {
            userViewModel.setEmail(email);
        }
        Timestamp createTime = userEntity.getCreateTime();
        if(createTime != null) {
            userViewModel.setCreateTime(createTime.toString());
        }
        String firstName = userEntity.getFirstName();
        if(!StringUtils.isEmpty(firstName)) {
            userViewModel.setFirstName(firstName);
        }
        String lastName = userEntity.getLastName();
        if(!StringUtils.isEmpty(lastName)) {
            userViewModel.setLastName(lastName);
        }
        logger.debug("Nested conversion UserEntity to UserViewModel completed.");
    }

}