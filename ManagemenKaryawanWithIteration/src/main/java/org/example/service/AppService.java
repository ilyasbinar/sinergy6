package org.example.service;


import org.example.controller.EmployeeController;

public class AppService {
    private static boolean exit = false;

    public static void setExit(boolean exit) {
        AppService.exit = exit;
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
        while(!exit){
            employeeController.menu();
        }

    }
}
