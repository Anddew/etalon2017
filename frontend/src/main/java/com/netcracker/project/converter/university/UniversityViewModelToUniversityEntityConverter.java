package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.core.convert.converter.Converter;

public class UniversityViewModelToUniversityEntityConverter implements Converter<UniversityViewModel, UniversityEntity> {

    @Override
    public UniversityEntity convert(UniversityViewModel universityViewModel) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setId(Integer.parseInt(universityViewModel.getId()));
        universityEntity.setName(universityViewModel.getName());
        return universityEntity;
    }

}