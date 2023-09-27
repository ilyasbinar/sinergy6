package org.example.service;

import org.example.controller.EmployeeController;
import org.example.view.EmployeeView;

public class AppService {
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

        DepartementService ds = new DepartementService();
        ds.initiateData();

    }
    public void run(){
        //Home
        EmployeeController employeeController =  new EmployeeController();
        employeeController.home();
    }
}
