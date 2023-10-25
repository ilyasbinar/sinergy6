package org.binaracademy.Chapter4Spring.controller;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Product;
import org.binaracademy.Chapter4Spring.model.dto.ProductViewDto;
import org.binaracademy.Chapter4Spring.service.MerchantService;
import org.binaracademy.Chapter4Spring.service.ProductService;
import org.binaracademy.Chapter4Spring.view.HomeMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ProductController {
    @Autowired
    MerchantService merchantService;

    @Autowired
    ProductService productService;
    public void cara1(){
        List<Merchant> merchantOpenList = merchantService.getOpenMercant();
        List<Product> productFromMerchantOpenList = productService.getFromMerchant(merchantOpenList);

        //mapping List<Product> -> List<ProductViewDto>
    }

    public void cara2(){
//        List<Product> productFromMerchantOpenList = productService.getFromOpenMerchant();
        List<ProductViewDto> productFromMerchantOpenList = productService.getFromOpenMerchantViewDto();


    }
}
