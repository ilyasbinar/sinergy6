package com.example.threaddemo.controller;

import com.example.threaddemo.service.GetJokeCompletableFuture;
import com.example.threaddemo.jobs.Notifier;
import com.example.threaddemo.jobs.Waiter;
import com.example.threaddemo.model.Message;
import com.example.threaddemo.model.OrderDetail;
import com.example.threaddemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("hello")
public class HelloController {
    final
    OrderService orderService;

    public HelloController(OrderService orderService, GetJokeCompletableFuture getJokeCompletableFuture) {
        this.orderService = orderService;
        this.getJokeCompletableFuture = getJokeCompletableFuture;
    }

    final
    GetJokeCompletableFuture getJokeCompletableFuture;

    @GetMapping("/message")
    public String getMessage(){
        return "Hello from Employee";
    }

    @GetMapping("/order")
    public String order() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println("Order processing...");

        int totalHargaNasiGoreng = orderService.getSubTotal(20000, 5); //5 detik
        int totalHargaAyamBakar = orderService.getSubTotal(25000, 3); //5 detik
        int totalHargaEsTeh = orderService.getSubTotal(5000, 8); //5 detik

        int totalHarga = totalHargaNasiGoreng+totalHargaAyamBakar+totalHargaEsTeh;

        System.out.println("Order completed!");

        sw.stop();
        System.out.println("STOPWATCH: "+sw.getTotalTimeSeconds());
        return "Total Harga "+ totalHarga;
    }

    @GetMapping("/orderrunable")
    public String orderRunnable() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println("Order processing...");

        OrderDetail nasiGoreng = new OrderDetail(20000, 5);
        OrderDetail ayamBakar = new OrderDetail(25000, 3);
        OrderDetail esTeh = new OrderDetail(50000, 8);

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(nasiGoreng);
        orderDetails.add(ayamBakar);
        orderDetails.add(esTeh);

        int totalHarga=orderService.getTotal(orderDetails);

        System.out.println("Order completed!");
        sw.stop();
        System.out.println("STOPWATCH: "+sw.getTotalTimeSeconds());

        return "Total Harga "+totalHarga;
    }

    @GetMapping("/sync")
    public String sync() {
        Message msg = new Message();
        Waiter sendWa = new Waiter(msg);
        new Thread(sendWa, "waiter1").start();

        Waiter sendTelegram = new Waiter(msg);
        new Thread(sendTelegram, "waiter2").start();

        Notifier getNoHPNotifier = new Notifier(msg);
        new Thread(getNoHPNotifier, "notifier").start();

        return "DONE";
    }

    @GetMapping("/joke")
    public String joke() throws ExecutionException, InterruptedException {
        CompletableFuture<String> futureJoke = getJokeCompletableFuture.getJokeAsync();
        CompletableFuture<String> futureEmail = getJokeCompletableFuture.getEmailUser();

        CompletableFuture<Void> combineFuture = CompletableFuture.allOf(futureJoke, futureEmail);
        combineFuture.get();
        String theJoke = futureJoke.join();
        String theEmail = futureEmail.join();

        CompletableFuture<Boolean> futureSendEmail = getJokeCompletableFuture.sendEmailAsync(theEmail, theJoke);

        boolean success = futureSendEmail.join();
        if(success){
            return "Joke "+ theJoke+" berhasil terkirim ke "+theEmail;
        }else {
            return "Gagal kirim joke";
        }

    }
}
