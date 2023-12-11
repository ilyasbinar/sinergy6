package com.example.transactionDemo.service;

import com.example.transactionDemo.model.BankAccount;
import com.example.transactionDemo.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoServiceImpl implements SaldoService{

    final private BankAccountService bankAccountService;
    final private BankAccountRepository bankAccountRepository;


    public SaldoServiceImpl(BankAccountService bankAccountService, BankAccountRepository bankAccountRepository) {
        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void updateSaldoPengirim(long from, long nilai) {
        BankAccount pengirim = bankAccountService.getById(from);
        pengirim.setSaldo(pengirim.getSaldo()-nilai);
        bankAccountRepository.save(pengirim);

    }

    @Override
    public void updateSaldoPenerima(long to, long nilai) {
        BankAccount penerima = bankAccountService.getById(to);
        penerima.setSaldo(penerima.getSaldo()+nilai);
        bankAccountRepository.save(penerima);
    }
}
