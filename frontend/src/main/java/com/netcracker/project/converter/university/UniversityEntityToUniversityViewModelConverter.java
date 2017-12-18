package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.UniversityEntity;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class UniversityEntityToUniversityViewModelConverter implements Converter<UniversityEntity, UniversityViewModel> {

    private Logger logger = Logger.getLogger(UniversityEntityToUniversityViewModelConverter.class.getSimpleName());

    @Override
    public UniversityViewModel convert(UniversityEntity universityEntity) {
        UniversityViewModel universityViewModel = new UniversityViewModel();
        Integer id = universityEntity.getId();
        if(id != null) {
            universityViewModel.setId(String.valueOf(id));
        }
        String name = universityEntity.getName();
        if(name != null) {
            universityViewModel.setName(name);
        }
        logger.debug("Conversion UniversityEntity to UniversityViewModel completed.");
        return universityViewModel;
    }

}