package com.example.transactionDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService{
    @Autowired
    SaldoService saldoService;

    @Autowired
    LogService logService;

    @Override
    @Transactional //tx-id =1
    public void transfer(long from, long to, long nilai) {
        saldoService.updateSaldoPengirim(from, nilai);
        saldoService.updateSaldoPenerima(to, nilai);
        logService.logTransaksi(from, to, nilai);
    }
    @Override
    @Transactional(noRollbackFor = { NullPointerException.class }) //tx-id =1
    public void transferRequireNew(long from, long to, long nilai) {
        saldoService.updateSaldoPengirim(from, nilai);
        saldoService.updateSaldoPenerima(to, nilai);
        logService.logTransaksiRequireNew(from, to, nilai);
    }

    @Override
    @Transactional
    public void transferNotSupported(long from, long to, long nilai) {
        saldoService.updateSaldoPengirim(from, nilai);
        saldoService.updateSaldoPenerima(to, nilai);
        logService.logTransaksiNotSupported(from, to, nilai);

    }
}
