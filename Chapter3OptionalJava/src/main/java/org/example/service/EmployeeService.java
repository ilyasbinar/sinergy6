package org.example.service;

import org.example.Employee;
import org.example.repository.EmployeeRepository;

import java.util.Optional;

public class EmployeeService {
    public Employee getEmployeeById(String empId){
        EmployeeRepository employeeRepository =  new EmployeeRepository();
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        employeeOptional.ifPresent(System.out::println);

        employeeOptional.ifPresentOrElse(System.out::println, () -> {
            //logic empty

        });



//        employeeOptional.orElseThrow(() -> {
//            throw new RuntimeException();
//        });
//        Employee employee = employeeOptional.ifPresent(employee -> {
//            return employee;
//        });
//        return employee;

//        //  Opsi 1
//        if(employeeOptional.isEmpty()){
//            throw new RuntimeException();
//        }
//        return employeeOptional.get();

          // Opsi 2
//        if(employeeOptional.isPresent()){
//            return employeeOptional.get();
//        }else throw new RuntimeException();

        //Opsi 3
//        return employeeOptional.orElseThrow(() -> {
//            throw new RuntimeException();
//        });
        //Opsi 4
        return employeeOptional.orElseThrow();

    }
}
