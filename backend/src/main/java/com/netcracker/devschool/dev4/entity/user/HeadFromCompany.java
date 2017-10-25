package com.netcracker.devschool.dev4.entity.user;

import com.netcracker.devschool.dev4.entity.company.Company;

public class HeadFromCompany extends User {

    protected BusinessTitle businessTitle;
    protected Company company;

    public BusinessTitle getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(BusinessTitle businessTitle) {
        this.businessTitle = businessTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Role getRole() {
        return Role.HEAD_COMPANY;
    }

}
