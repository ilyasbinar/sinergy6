package com.example.transactionDemo.controller;

import com.example.transactionDemo.service.TransferService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
public class TransferController {
    final private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/{from}/{to}/{nilai}")
    public String transfer(@PathVariable long from,
                           @PathVariable long to,
                           @PathVariable long nilai){

        //transfer
        transferService.transfer(from, to, nilai);
        return "Transfer berhasil!";
    }

    @GetMapping("/rn/{from}/{to}/{nilai}")
    public String transferRequireNew(@PathVariable long from,
                           @PathVariable long to,
                           @PathVariable long nilai){

        //transfer
        transferService.transferRequireNew(from, to, nilai);
        return "Transfer berhasil!";
    }

    @GetMapping("/ns/{from}/{to}/{nilai}")
    public String transferNotSupported(@PathVariable long from,
                                     @PathVariable long to,
                                     @PathVariable long nilai){

        //transfer
        transferService.transferNotSupported(from, to, nilai);
        return "Transfer berhasil!";
    }
}
