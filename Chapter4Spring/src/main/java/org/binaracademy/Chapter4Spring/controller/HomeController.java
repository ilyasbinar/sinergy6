package org.binaracademy.Chapter4Spring.controller;

import org.binaracademy.Chapter4Spring.repository.MerchantRepository;
import org.binaracademy.Chapter4Spring.view.HomeMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HomeController {
    @Autowired
    MerchantController merchantController;

     public void home(){
         merchantController.ujiCobaProcedure();
        HomeMenu.welcomeMessage();
        HomeMenu.mainMenuOption();
        selectMainMenu();
    }

    private void selectMainMenu() {
        Scanner scan = new Scanner(System.in);
        int mainMenuSelected = scan.nextInt();
        if(mainMenuSelected==1){
            merchantController.index();
        }else{

        }
    }
}
