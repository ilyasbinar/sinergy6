package com.example.firstservice;

import java.util.concurrent.TimeUnit;

public class HitungTotalPerMerchant {
    public int total(int harga, int kuantitas) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return harga*kuantitas;
    }
}
