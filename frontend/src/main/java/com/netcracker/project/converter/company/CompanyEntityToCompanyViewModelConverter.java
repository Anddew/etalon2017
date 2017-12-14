package com.netcracker.project.converter.company;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import org.springframework.core.convert.converter.Converter;

public class CompanyEntityToCompanyViewModelConverter implements Converter<CompanyEntity, CompanyViewModel> {

    @Override
    public CompanyViewModel convert(CompanyEntity companyEntity) {
        CompanyViewModel companyViewModel = new CompanyViewModel();
        int id = companyEntity.getId();
        if(id != 0) {
            companyViewModel.setId(String.valueOf(id));
        }
        String name = companyEntity.getName();
        if(name != null) {
            companyViewModel.setName(name);
        }
        return companyViewModel;
    }

}