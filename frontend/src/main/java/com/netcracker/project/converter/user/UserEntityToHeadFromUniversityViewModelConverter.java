package com.netcracker.project.converter.user;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.user.HeadFromUniversityViewModel;
import com.netcracker.project.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToHeadFromUniversityViewModelConverter implements Converter<UserEntity, HeadFromUniversityViewModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public HeadFromUniversityViewModel convert(UserEntity userEntity) {
        HeadFromUniversityViewModel headFromUniversityViewModel = new HeadFromUniversityViewModel();
        headFromUniversityViewModel.setFaculty(conversionService.convert(userEntity.getFaculty(), FacultyViewModel.class));
        headFromUniversityViewModel.setId(String.valueOf(userEntity.getId()));
        headFromUniversityViewModel.setUsername(userEntity.getUsername());
        headFromUniversityViewModel.setEmail(userEntity.getEmail());
        headFromUniversityViewModel.setCreateTime(userEntity.getCreateTime().toString());
        headFromUniversityViewModel.setFirstName(userEntity.getFirstName());
        headFromUniversityViewModel.setLastName(userEntity.getLastName());
        return headFromUniversityViewModel;
    }
}