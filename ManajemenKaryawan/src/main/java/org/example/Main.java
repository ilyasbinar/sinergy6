package org.example;

import org.example.service.AppService;
import org.example.service.CSVDataService;

public class Main {
    public static void main(String[] args) {

        AppService appService = new AppService();
        //initiate data employee and departement
        appService.initiateData();

        appService.run();
    }
}