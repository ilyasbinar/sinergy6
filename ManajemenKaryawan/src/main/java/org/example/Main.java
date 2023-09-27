package org.example;

import org.example.service.AppService;
import org.example.view.GeneralView;

public class Main {
    public static void main(String[] args) {

        AppService appService = new AppService();
        //initiate data employee and departement
        appService.initiateData();

        appService.run();

    }
}