package com.example.threaddemo.service;

import com.example.threaddemo.jobs.OrderRunnable;
import com.example.threaddemo.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    public int getSubTotal(int harga, int kuantitas) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return harga*kuantitas;
    }

    public int getSubTotalRunnable(int harga, int kuantitas){
        OrderRunnable orderRunnable = new OrderRunnable(harga, kuantitas);
        Thread thread= new Thread(orderRunnable);
        thread.start();
        return orderRunnable.getTotal();
    }

    public int getTotal(List<OrderDetail> orderDetails) {
        int total = 0;

        OrderRunnable orderRunnableNG = new OrderRunnable(20000, 5);
        Thread threadNG = new Thread(orderRunnableNG);
        threadNG.start();

        OrderRunnable orderRunnableAB = new OrderRunnable(25000, 3);
        Thread threadAB = new Thread(orderRunnableAB);
        threadAB.start();

        OrderRunnable orderRunnableET = new OrderRunnable(25000, 3);
        Thread threadET = new Thread(orderRunnableET);
        threadET.start();

        try {
            threadNG.join();
            threadAB.join();
            threadET.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        total = orderRunnableNG.getTotal()+ orderRunnableAB.getTotal()+ orderRunnableET.getTotal();
        return total;
    }
}
