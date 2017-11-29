package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.core.convert.converter.Converter;

public class UniversityEntityToUniversityViewModelConverter implements Converter<UniversityEntity, UniversityViewModel> {

    @Override
    public UniversityViewModel convert(UniversityEntity universityEntity) {
        UniversityViewModel universityViewModel = new UniversityViewModel();
        universityViewModel.setId(String.valueOf(universityEntity.getId()));
        universityViewModel.setName(universityEntity.getName());
        return universityViewModel;
    }

}