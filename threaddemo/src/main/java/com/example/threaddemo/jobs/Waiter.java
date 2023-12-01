package com.example.threaddemo.jobs;

import com.example.threaddemo.model.Message;

public class Waiter implements Runnable{
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg){
            try {
                System.out.println(name + " menunggu untuk mendapatkan notifikasi pada waktu "
                        + System.currentTimeMillis());

                msg.wait();

                System.out.println(name + " telah mendapatkan notifikasi pada waktu "
                        + System.currentTimeMillis());
                System.out.println(name + " Pesannya adalah " + msg.getContent());
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        }

    }
}
