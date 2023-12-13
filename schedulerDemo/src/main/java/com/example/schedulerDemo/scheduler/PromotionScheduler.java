package com.example.schedulerDemo.scheduler;

import com.example.schedulerDemo.model.Product;
import com.example.schedulerDemo.model.User;
import com.example.schedulerDemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PromotionScheduler {
    final private EmailService emailService;

    public PromotionScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    //    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void fixedRate(){
        System.out.println("fixedRate: "+new Date());
    }

//    @Scheduled(initialDelay = 15, fixedDelay = 4, timeUnit = TimeUnit.SECONDS)
    public void fixedDelay(){
        System.out.println("fixedDelay: "+new Date());
    }



//    @Scheduled(cron = "0 * 20 * * *") //setiap menit hanya pada pukul 20
//    @Scheduled(cron = "* * 20 * * *") //setiap detik hanya pada pukul 20
//    @Scheduled(cron = "0 0 1 * * SUN") //setiap hari minggu pukul 01:00
//    @Scheduled(cron = "* * * 13 * *") //setiap detik hanya pada tanggal 13
    @Scheduled(cron = "45 47 20 * * *") //setiap hari di pukul 20 27
    public void cronJob(){
        List<Product> productList = new ArrayList<>(); //TODO: ambil product promosi
        productList.add(new Product("Nasi Goreng", 15000));
        productList.add(new Product("Ayam Goreng", 20000));

        List<User> userList = new ArrayList<>();
        userList.add(new User("ilyas", "milyas@binar.com"));  //TODO ambil user target promosi

        emailService.sendPromotionMail(productList, userList);
    }
}
