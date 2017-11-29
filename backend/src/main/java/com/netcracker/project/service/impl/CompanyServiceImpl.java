package com.netcracker.project.service.impl;

import com.netcracker.project.repository.CompanyRepository;
import com.netcracker.project.repository.FacultyRepository;
import com.netcracker.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

}
