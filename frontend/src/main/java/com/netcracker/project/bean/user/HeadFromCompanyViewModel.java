package com.netcracker.project.bean.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.user.UserRole;

public class HeadFromCompanyViewModel extends UserViewModel {

    private CompanyViewModel company;

    public CompanyViewModel getCompany() {
        return company;
    }

    public void setCompany(CompanyViewModel company) {
        this.company = company;
    }

    @Override
    public UserRole getRole() {
        return UserRole.HEAD_FROM_COMPANY;
    }

    @Override
    public String toString() {
        return "HeadFromCompanyViewModel{" +
                "company=" + company +
                "} " + super.toString();
    }
}
