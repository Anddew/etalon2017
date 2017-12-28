package com.netcracker.project.converter.company;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;

import org.apache.log4j.Logger;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class CompanyViewModelToCompanyEntityConverter implements Converter<CompanyViewModel, CompanyEntity> {

    private Logger logger = Logger.getLogger(CompanyViewModelToCompanyEntityConverter.class.getSimpleName());


    @Override
    public CompanyEntity convert(CompanyViewModel companyViewModel) {
        CompanyEntity companyEntity = new CompanyEntity();
        String id = companyViewModel.getId();
        if(!StringUtils.isEmpty(id)) {
            companyEntity.setId(Integer.parseInt(id));
        }
        String name = companyViewModel.getName();
        if(!StringUtils.isEmpty(name)) {
            companyEntity.setName(name);
        }
        logger.debug("Conversion CompanyViewModel to CompanyEntity completed.");
        return companyEntity;
    }

}