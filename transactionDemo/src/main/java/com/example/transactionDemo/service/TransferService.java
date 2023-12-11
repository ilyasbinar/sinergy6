package com.example.transactionDemo.service;

import org.springframework.stereotype.Service;


public interface TransferService {
    void transfer(long from, long to, long nilai);

    void transferRequireNew(long from, long to, long nilai);

    void transferNotSupported(long from, long to, long nilai);

}
