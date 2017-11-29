package com.netcracker.project.bean.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.user.Role;

public class HeadFromCompanyViewModel extends UserViewModel {

    private CompanyViewModel company;

    public CompanyViewModel getCompany() {
        return company;
    }

    public void setCompany(CompanyViewModel company) {
        this.company = company;
    }

    @Override
    public Role getRole() {
        return Role.HEAD_FROM_COMPANY;
    }

}
