package com.netcracker.etalon.beans;

public class Company {

    private int id;
    private String name;
    private CompanyPositions companyPositions = new CompanyPositions();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
