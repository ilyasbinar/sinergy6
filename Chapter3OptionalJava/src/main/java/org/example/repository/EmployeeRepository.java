package org.example.repository;

import org.example.Employee;

import java.util.Optional;

public class EmployeeRepository {

    public Optional<Employee> findById(String empId){
        Optional<Employee> employeeOptional = Optional.empty();
        return employeeOptional;
    }
}
