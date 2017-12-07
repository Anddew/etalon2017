package com.netcracker.project.converter.user;

import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class HeadFromUniversityViewModelToUserEntityConverter implements Converter<HeadFromUniversityViewModel, UserEntity> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserEntity convert(HeadFromUniversityViewModel headFromUniversityViewModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(headFromUniversityViewModel.getId()));
        userEntity.setRole(UserRole.valueOf(headFromUniversityViewModel.getRole().getDescription()));
        userEntity.setUsername(headFromUniversityViewModel.getUsername());
        userEntity.setPassword(headFromUniversityViewModel.getPassword());
        userEntity.setEmail(headFromUniversityViewModel.getEmail());
        userEntity.setCreateTime(Timestamp.valueOf(headFromUniversityViewModel.getCreateTime()));
        userEntity.setFirstName(headFromUniversityViewModel.getFirstName());
        userEntity.setLastName(headFromUniversityViewModel.getLastName());
        userEntity.setFaculty(conversionService.convert(headFromUniversityViewModel.getFaculty(), FacultyEntity.class));
        return userEntity;
    }


}