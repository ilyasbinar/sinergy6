package org.example;

import java.util.List;

public class Departemen {
    /*
    IT, HRD, dst
     */

    private String nama;

    private List<Employee> employeeList;

    public Departemen(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
