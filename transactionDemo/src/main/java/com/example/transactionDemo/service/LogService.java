package com.example.transactionDemo.service;

import org.springframework.stereotype.Service;


public interface LogService {
    void logTransaksi(long from, long to, long nilai);

    void logTransaksiRequireNew(long from, long to, long nilai);

    void logTransaksiNotSupported(long from, long to, long nilai);

}
