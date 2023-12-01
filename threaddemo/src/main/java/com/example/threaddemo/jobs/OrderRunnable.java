package com.example.threaddemo.jobs;

import java.util.concurrent.TimeUnit;

public class OrderRunnable implements Runnable{
    private int harga;
    private int kuantitas;
    private int total;

    public OrderRunnable(int harga, int kuantitas) {
        this.harga = harga;
        this.kuantitas = kuantitas;
    }

    @Override
    public void run() {
        try {
            System.out.println("calculating...: "+harga);
            Thread.sleep(5000);
            total=harga*kuantitas;
            System.out.println("calculated: "+harga+ ". total: "+total);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
