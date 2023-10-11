package org.example.service;

import org.example.controller.EmployeeController;
import org.example.model.Departement;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.view.EmployeeView;
import org.example.view.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartementService departementService;


    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void selectOption(int optionSelected) {
        switch (optionSelected) {
            case 1 -> tambahEmployee();
            case 2 -> showEmployee();
            case 3 -> {
                //TODO: ubah employee
            }
            case 4 -> {
                //TODO: hapus employee
            }
        }
    }

    public void tambahEmployee() {
        EmployeeView employeeView = new EmployeeView();
        EmployeeController employeeController = new EmployeeController();

        System.out.println("Silakan masukkan data pegawai.");
        Employee e = new Employee();
        employeeView.fieldName();
        e.setName(employeeController.inputName());
        employeeView.fieldEmpId();
        e.setEmpId(employeeController.inputEmpId());
        employeeView.fieldAddress();
        e.setAddress(employeeController.inputAddress());
        employeeView.fieldDepartement(departementService.getDepartements());

        int departementSelected = employeeController.inputDepartement();
        Departement departement =  departementService.getById(departementSelected);
        e.setDepartement(departement);
        employeeRepository.save(e);
    }


    public void showEmployee() {
        EmployeeView employeeView = new EmployeeView();
        EmployeeController employeeController = new EmployeeController();
        employeeView.inputEmpIdForm();
        String empId = employeeController.inputEmpId();
        Employee employee = employeeRepository.findByEmpId(empId);

    }

    public Employee getEmployeeByEmpId(String empId) {

        Employee employee =  employeeRepository.findByEmpId(empId);
        if(employee == null){
            ErrorView errorView = new ErrorView();
            errorView.wrongEmpId();
        }
        return employee;
    }
}
