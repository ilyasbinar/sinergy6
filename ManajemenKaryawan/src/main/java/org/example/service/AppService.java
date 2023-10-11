package org.example.service;

import org.example.controller.EmployeeController;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private final EmployeeController employeeController;
    private final DepartementService departementService;

    public AppService(EmployeeController employeeController, DepartementService departementService) {
        this.employeeController = employeeController;
        this.departementService = departementService;
    }
    private boolean EXIT=false;

    public boolean isEXIT() {
        return EXIT;
    }

    public void setEXIT(boolean EXIT) {
        this.EXIT = EXIT;
    }

    public void initiateData() {
        //import latest data employee from CSV
        CSVDataService csvDataService = new CSVDataService();
        csvDataService.importData();

        departementService.initiateData();

    }
    public void run(){
        //Home
        employeeController.home();
    }
}
