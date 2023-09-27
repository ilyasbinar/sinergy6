package org.example;

import org.example.service.AppService;

public class Main {
    public static void main(String[] args) {

        AppService appService = new AppService();
        //initiate data employee and departement
        appService.initiateData();

        appService.run();

    }
}