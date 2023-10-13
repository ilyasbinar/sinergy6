package org.example.service;

import org.example.controller.EmployeeController;
import org.example.model.Departement;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.view.EmployeeView;
import org.example.view.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    DepartementService departementService;

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository userRepository) {
        this.employeeRepository = userRepository;
    }


    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
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

    public Employee tambah(Employee e) {
        e.setCreatedDate(LocalDateTime.now());
        return employeeRepository.save(e);
    }
}
