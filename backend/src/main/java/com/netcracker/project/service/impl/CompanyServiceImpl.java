package com.netcracker.project.service.impl;

import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.repository.CompanyRepository;
import com.netcracker.project.service.CompanyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private Logger logger = Logger.getLogger(CompanyServiceImpl.class);


    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public void createCompany(CompanyEntity company) {
        // TODO: 28.12.2017
        logger.debug("Creating company feature is under construction.");
        throw new UnsupportedOperationException("This feature is under construction.");
    }

}
