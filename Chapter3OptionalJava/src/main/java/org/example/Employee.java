package org.example;

import java.util.Optional;

public class Employee {
    private String empId;

    private String address;

    private Departement departement;


    public Employee(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAddress() {
        return address;
    }

    public Optional<String> getAddressOptional(){
        return Optional.ofNullable(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departement getDepartement() {
        return departement;
    }

    public Optional<Departement> getDepartementOptional(){
        return Optional.ofNullable(departement);
    }
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
