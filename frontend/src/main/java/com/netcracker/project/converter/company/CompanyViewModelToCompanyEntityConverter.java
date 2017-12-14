package com.netcracker.project.converter.company;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import org.springframework.core.convert.converter.Converter;

public class CompanyViewModelToCompanyEntityConverter implements Converter<CompanyViewModel, CompanyEntity> {

    @Override
    public CompanyEntity convert(CompanyViewModel companyViewModel) {
        CompanyEntity companyEntity = new CompanyEntity();
        String id = companyViewModel.getId();
        if(id != null) {
            companyEntity.setId(Integer.parseInt(id));
        }
        String name = companyViewModel.getName();
        if(name != null) {
            companyEntity.setName(name);
        }
        return companyEntity;
    }

}