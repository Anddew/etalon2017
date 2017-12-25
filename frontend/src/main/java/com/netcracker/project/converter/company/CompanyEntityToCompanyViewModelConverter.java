package com.netcracker.project.converter.company;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.company.CompanyEntity;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class CompanyEntityToCompanyViewModelConverter implements Converter<CompanyEntity, CompanyViewModel> {

    private Logger logger = Logger.getLogger(CompanyEntityToCompanyViewModelConverter.class.getSimpleName());

    @Override
    public CompanyViewModel convert(CompanyEntity companyEntity) {
        CompanyViewModel companyViewModel = new CompanyViewModel();
        Integer id = companyEntity.getId();
        if(id != null) {
            companyViewModel.setId(String.valueOf(id));
        }
        String name = companyEntity.getName();
        if(!StringUtils.isEmpty(name)) {
            companyViewModel.setName(name);
        }
        logger.debug("Conversion CompanyEntity to CompanyViewModel completed.");
        return companyViewModel;
    }

}