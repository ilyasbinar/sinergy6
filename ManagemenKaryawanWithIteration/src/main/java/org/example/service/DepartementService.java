package org.example.service;

import org.example.model.Data;
import org.example.model.Departement;

import java.util.Map;

public class DepartementService {

    public void initiateData() {

        Data.departementMap.put(1, new Departement().setName("Sales & Marketing"));
        Data.departementMap.put(2, new Departement().setName("Human Resources"));
        Data.departementMap.put(3, new Departement().setName("Information & Technology"));
        Data.departementMap.put(4, new Departement().setName("Purchasing"));
        Data.departementMap.put(5, new Departement().setName("Accounting"));
        Data.departementMap.put(6, new Departement().setName("General Affair"));
    }

    public Map<Integer, Departement> getDepartements() {
        return Data.departementMap;
    }
}
