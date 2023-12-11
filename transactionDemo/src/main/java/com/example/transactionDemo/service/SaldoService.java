package com.example.transactionDemo.service;

import org.springframework.stereotype.Service;

public interface SaldoService {

    void updateSaldoPengirim(long from, long nilai);

    void updateSaldoPenerima(long to, long nilai);

}
