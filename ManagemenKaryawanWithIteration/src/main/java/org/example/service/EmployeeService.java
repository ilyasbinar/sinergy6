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
        e.setAddress(null);

        employeeView.fieldDepartement();

        int departementSelected = employeeController.inputDepartement();
        Departement departement =  Data.departementMap.get(departementSelected);
        e.setDepartement(departement);
        createEmployee(e);
    }
    public void createEmployee(Employee e){
        Data.employees.add(e);
    }

    public Employee getEmployeeByEmpId(String empId) {

        List<Employee> empList = Data.employees;

        Employee employee = null;
        Optional<Employee> employeeOptional =  Data.employees.stream().filter(p->p.getEmpId().equals(empId)).findFirst();
        if(employeeOptional.isEmpty()){
            ErrorView errorView = new ErrorView();
            errorView.wrongEmpId();
        }else {
            employee = employeeOptional.get();
        }
        return employee;
    }
}
