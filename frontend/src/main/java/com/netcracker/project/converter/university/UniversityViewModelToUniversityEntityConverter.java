package com.netcracker.project.converter.university;

import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.UniversityEntity;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class UniversityViewModelToUniversityEntityConverter implements Converter<UniversityViewModel, UniversityEntity> {

    private Logger logger = Logger.getLogger(UniversityViewModelToUniversityEntityConverter.class.getSimpleName());

    @Override
    public UniversityEntity convert(UniversityViewModel universityViewModel) {
        UniversityEntity universityEntity = new UniversityEntity();
        String id = universityViewModel.getId();
        if(!StringUtils.isEmpty(id)) {
            universityEntity.setId(Integer.parseInt(id));
        }
        String name = universityViewModel.getName();
        if(!StringUtils.isEmpty(name)) {
            universityEntity.setName(name);
        }
        logger.debug("Conversion UniversityViewModel to UniversityEntity completed.");
        return universityEntity;
    }

}