package org.example;

import java.util.List;
import java.util.Optional;

public class Departement {
    private String name;

    private List<Employee> employeeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<List<Employee>> getEmployeeListOptional(){
        ///
        return Optional.ofNullable(employeeList);
    }
}
