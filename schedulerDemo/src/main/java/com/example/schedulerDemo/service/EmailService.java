package com.example.schedulerDemo.service;

import com.example.schedulerDemo.model.Product;
import com.example.schedulerDemo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    public void sendPromotionMail(List<Product> promotionProductList, List<User> userList){
        //kirim email promosi
        for(User u: userList){
            //todo: kirim email
            try {
                System.out.println("Email promosi sudah terkirim untuk product");
                for(Product p:promotionProductList){
                    System.out.println(p.getName()+": "+p.getPrice());
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
