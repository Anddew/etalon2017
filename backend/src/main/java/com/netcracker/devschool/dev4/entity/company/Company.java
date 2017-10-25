package com.netcracker.devschool.dev4.entity.company;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private int id;
    private String name;
    private List<String> positionsList = new ArrayList<>();

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

    public void addPosition(String position) {
        positionsList.add(position);
    }

    public void removePosition(String position) {
        positionsList.remove(position);
    }

    public List<String> getPositionsList() {
        return positionsList;
    }

}
