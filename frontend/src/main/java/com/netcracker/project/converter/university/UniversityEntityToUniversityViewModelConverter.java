package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.UniversityEntity;
import org.springframework.core.convert.converter.Converter;

public class UniversityEntityToUniversityViewModelConverter implements Converter<UniversityEntity, UniversityViewModel> {

    @Override
    public UniversityViewModel convert(UniversityEntity universityEntity) {
        UniversityViewModel universityViewModel = new UniversityViewModel();
        int id = universityEntity.getId();
        if(id != 0) {
            universityViewModel.setId(String.valueOf(id));
        }
        String name = universityEntity.getName();
        if(name != null) {
            universityViewModel.setName(name);
        }
        return universityViewModel;
    }

}