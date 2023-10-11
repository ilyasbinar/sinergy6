package org.example.controller;

import org.example.model.Employee;
import org.example.service.CSVDataService;
import org.example.service.DepartementService;
import org.example.service.EmployeeService;
import org.example.view.EmployeeView;
import org.example.view.ErrorView;
import org.example.view.GeneralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class EmployeeController {
   @Autowired
   EmployeeService employeeService;

   @Autowired
   DepartementService departementService;

    public EmployeeController() {
    }

    public void home(){
        GeneralView.welcomeMessage();
        menu();
    }

    public void menu() {
        EmployeeView employeeView = new EmployeeView();
        List<Employee> employees = employeeService.getEmployees();

        employeeView.tableEmployee(employees);
        GeneralView.menuOption();
        selectMenu();
    }

    public void selectMenu(){
        try {
            Scanner scanner = new Scanner(System.in);
            int selectedMenu = scanner.nextInt();

            switch (selectedMenu) {
                case 1 -> addEmployee();
                case 2 -> showEmployee();
                case 3, 4 -> {
                   //TODO tobe implemented
                } case 0 ->{
                    CSVDataService csvDataService = new CSVDataService();
                    csvDataService.exportData();
                }
                default -> {
                    ErrorView errorView = new ErrorView();
                    errorView.wrongOptionIntput();
                }
            }
        }catch (InputMismatchException e){
            // print to the log
        }
    }

    private void addEmployee() {
        employeeService.tambahEmployee();
        menu();
    }

    public void showEmployee(){
        EmployeeView employeeView = new EmployeeView();
        employeeView.inputEmpIdForm();
        String empId = inputEmpId();
        Employee employee = employeeService.getEmployeeByEmpId(empId);
        employeeDetail(employee);
    }

    private void employeeDetail(Employee employee) {
        EmployeeView employeeView = new EmployeeView();
        employeeView.showEmployee(employee);
        menu();
    }

    public String inputName() {
        return inputLine();
    }

    public String inputEmpId() {
        return inputLine();
    }

    public String inputAddress() {
        return inputLine();
    }

    public String inputLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int inputDepartement() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
