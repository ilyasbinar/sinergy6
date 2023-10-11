package org.example;

import org.example.service.AppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManajemenKaryawan {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =  SpringApplication.run(ManajemenKaryawan.class, args);
        AppService appService = context.getBean(AppService.class);
        //initiate data employee and departement
        appService.initiateData();

        appService.run();

    }
}