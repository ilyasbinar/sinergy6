package org.example.service;

public class ElectronicPriceServiceImpl implements PriceService {

//    @Override
//    public Long getPrice2() {
//        return 100000L;
//    }

    @Override
    public Long getPrice(String code) {
        //logic basePrice=-besePrice*discount;
        long basePrice = 5000000;
        long discount =100000;
        return basePrice-discount;
    }
}
