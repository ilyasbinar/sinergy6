package org.binaracademy.Chapter4Spring.controller;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.service.MerchantService;
import org.binaracademy.Chapter4Spring.view.MerchantView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    private final static Logger logger = LoggerFactory.getLogger(MerchantController.class);


    public void index(){
        List<Merchant> merchantList = merchantService.getAll();
        MerchantView.showAllMerchant(merchantList);
        MerchantView.showMerchantMenuOption();
        selectMerchantMenu();
    }

    private void merchantMenuOption() {
    }

    private void selectMerchantMenu() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        try{
            int merchantMenuSelected = scan.nextInt();
            if(merchantMenuSelected==1){
                addMerchant();
            } else if (merchantMenuSelected==2) {
                editStatusMerchant();
            } else{

            }
        }catch (InputMismatchException | InterruptedException e){
            logger.error(e.toString());
        }
    }

    private void editStatusMerchant() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nama: ");
        String name = scan.nextLine();

        System.out.print("T(Tutup) atau B(Buka): ");
        String statusInput = scan.nextLine();
        boolean status;
        if(statusInput.equalsIgnoreCase("T")){
            status = false;
        }else{
            status = true;
        }

        merchantService.editStatusMerchantByName(name, status);
        index();

    }

    private void addMerchant() throws InterruptedException {
        Merchant merchant = new Merchant();
        Scanner scan = new Scanner(System.in);

        System.out.print("Nama: ");
        String name = scan.nextLine();
        merchant.setName(name);

        System.out.print("Location: ");
        String location = scan.nextLine();
        merchant.setLocation(location);

        merchantService.create(merchant);
        index();
    }
}
