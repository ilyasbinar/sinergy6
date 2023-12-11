package com.example.transactionDemo.service;

import com.example.transactionDemo.model.LogTransaction;
import com.example.transactionDemo.repository.LogTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogTransactionRepository logTransactionRepository;

    @Autowired
    BankAccountService bankAccountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW) //tx-id=2
    public void logTransaksi(long from, long to, long nilai) {
        LogTransaction logTransaction = new LogTransaction();
        logTransaction.setPengirim(bankAccountService.getById(from));
        logTransaction.setPenerima(bankAccountService.getById(to));
        logTransaction.setNilai(nilai);
        logTransactionRepository.save(logTransaction);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)//tx-id=2
    public void logTransaksiRequireNew(long from, long to, long nilai) {
        LogTransaction logTransaction = new LogTransaction();
        logTransaction.setPengirim(bankAccountService.getById(from));
        logTransaction.setPenerima(bankAccountService.getById(to));
        logTransaction.setNilai(nilai);
        logTransactionRepository.save(logTransaction);

        LogTransaction logTransaction1 = null;
        logTransaction1.setNilai(nilai);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)//tx-id=2
    public void logTransaksiNotSupported(long from, long to, long nilai) {
        LogTransaction logTransaction = new LogTransaction();
        logTransaction.setPengirim(bankAccountService.getById(from));
        logTransaction.setPenerima(bankAccountService.getById(to));
        logTransaction.setNilai(nilai);
        logTransactionRepository.save(logTransaction);

        LogTransaction logTransaction1 = null;
        logTransaction1.setNilai(nilai);
    }
}
