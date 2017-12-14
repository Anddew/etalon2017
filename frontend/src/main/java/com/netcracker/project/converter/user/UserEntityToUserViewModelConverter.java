package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public abstract class UserEntityToUserViewModelConverter {

    public void setUserFields(UserViewModel userViewModel, UserEntity userEntity) {
        int id = userEntity.getId();
        if(id != 0) {
            userViewModel.setId(String.valueOf(id));
        }
        String username = userEntity.getUsername();
        if(username != null) {
            userViewModel.setUsername(username);
        }
        String email = userEntity.getEmail();
        if(email != null) {
            userViewModel.setEmail(email);
        }
        Timestamp createTime = userEntity.getCreateTime();
        if(createTime != null) {
            userViewModel.setCreateTime(createTime.toString());
        }
        String firstName = userEntity.getFirstName();
        if(firstName != null) {
            userViewModel.setFirstName(firstName);
        }
        String lastName = userEntity.getLastName();
        if(lastName != null) {
            userViewModel.setLastName(lastName);
        }
    }

}