package org.binaracademy.Chapter4Spring.controller;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping("")
    public List<Merchant> index(){
        //menampilkan seluruh merchant
        List<Merchant> merchantList = merchantService.getAll();

        Merchant auliaStore = new Merchant()
                .setId(UUID.randomUUID())
                .setName("Aulia Store");
        merchantList.add(auliaStore);

        return merchantList;
    }


    @GetMapping("/add")
    public Merchant add(){
        Merchant nur = new Merchant()
                .setName("Nur Store");
        return merchantService.create(nur);
    }
}
