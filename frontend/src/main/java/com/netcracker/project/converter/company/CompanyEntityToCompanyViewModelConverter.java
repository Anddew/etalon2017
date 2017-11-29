package com.netcracker.project.converter.company;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import org.springframework.core.convert.converter.Converter;

public class CompanyEntityToCompanyViewModelConverter implements Converter<CompanyEntity, CompanyViewModel> {

    @Override
    public CompanyViewModel convert(CompanyEntity companyEntity) {
        CompanyViewModel companyViewModel = new CompanyViewModel();
        companyViewModel.setId(String.valueOf(companyEntity.getId()));
        companyViewModel.setName(companyEntity.getName());
        return companyViewModel;
    }
}