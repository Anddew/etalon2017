package com.netcracker.etalon.beans;

import java.util.ArrayList;
import java.util.List;

public class CompanyPositions {

    private List<String> positions = new ArrayList<>();

    public void addPosition(String position) {
        positions.add(position);
    }

    public List<String> getPositionsList() {
        return positions;
    }

}
