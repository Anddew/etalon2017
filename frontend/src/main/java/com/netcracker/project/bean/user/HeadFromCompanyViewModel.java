package com.netcracker.project.bean.user;

import com.netcracker.project.bean.company.CompanyViewModel;
import com.netcracker.project.entity.user.UserRole;

import java.util.Objects;

public class HeadFromCompanyViewModel extends UserViewModel {

    private static final long serialVersionUID = -96480478069757528L;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadFromCompanyViewModel that = (HeadFromCompanyViewModel) o;
        return Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company);
    }

    @Override
    public String toString() {
        return "HeadFromCompanyViewModel{" +
                "company=" + company +
                "} " + super.toString();
    }
}
