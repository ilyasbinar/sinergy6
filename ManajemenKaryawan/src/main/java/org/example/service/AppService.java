package org.example.service;

import org.example.controller.EmployeeController;
import org.example.view.EmployeeView;

public class AppService {
    public static boolean EXIT=false;

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
