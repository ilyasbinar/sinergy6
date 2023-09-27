package org.example.service;

import org.example.controller.EmployeeController;
import org.example.model.Data;
import org.example.model.Departement;
import org.example.model.Employee;
import org.example.view.EmployeeView;
import org.example.view.ErrorView;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    public List<Employee> getEmployees(){
        return Data.employees;
    }

    public void tambahEmployee() {
        EmployeeController employeeController = new EmployeeController();
        EmployeeView employeeView = new EmployeeView();

        System.out.println("Silakan masukkan data pegawai.");
        Employee e = new Employee();
        employeeView.fieldName();
        e.setName(employeeController.inputName());
        employeeView.fieldEmpId();
        e.setEmpId(employeeController.inputEmpId());
        employeeView.fieldAddress();
        e.setAddress(employeeController.inputAddress());
        employeeView.fieldDepartement();

        int departementSelected = employeeController.inputDepartement();
        Departement departement =  Data.departementMap.get(departementSelected);
        e.setDepartement(departement);
        Data.employees.add(e);
    }

    public Employee getEmployeeByEmpId(String empId) {

        Optional<Employee> employee =  Data.employees.stream().filter(p->p.getEmpId().equals(empId)).findFirst();
        if(employee.isEmpty()){
            ErrorView errorView = new ErrorView();
            errorView.wrongEmpId();
        }
        return employee.get();
    }
}
