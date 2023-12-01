package com.example.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class EmployeeController {

    @GetMapping("/message")
    public String getMessage(){
        return "Hello from Employee";
    }

    @GetMapping("/order")
    public String order() throws InterruptedException {

        //thread 1
        HitungTotalPerMerchant hitungTotalPerMerchant = new HitungTotalPerMerchant();

        //open thread 2
        int totalHargaMerchant1 = hitungTotalPerMerchant.total(10000, 100); //5 detik
        //open thread 3
        int totalHargaMerchant2 = hitungTotalPerMerchant.total(20000, 10); //5 detik
        //open thread 4
        int totalHargaMerchant3 = hitungTotalPerMerchant.total(30000, 50); //5 detik

        //thread 1
        int totalHarga = totalHargaMerchant1+totalHargaMerchant2+totalHargaMerchant3;

        return "Hello from Employee"+ totalHarga;
    }
}
