package com.example.threaddemo.jobs;

import com.example.threaddemo.model.Message;

public class Notifier implements Runnable{
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            synchronized (msg){
                Thread.sleep(10000);
                msg.setContent("Pesan diset dari Notifier");
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
