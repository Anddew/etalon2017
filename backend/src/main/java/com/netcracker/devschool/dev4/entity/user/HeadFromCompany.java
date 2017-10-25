package com.netcracker.devschool.dev4.entity.user.headfromcompany;

import com.netcracker.devschool.dev4.entity.company.Company;
import com.netcracker.devschool.dev4.entity.user.Role;
import com.netcracker.devschool.dev4.entity.user.User;

public class HeadFromCompany extends User {

    protected String position;
    protected Company company;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
