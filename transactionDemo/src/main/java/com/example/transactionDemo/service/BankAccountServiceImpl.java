package com.example.transactionDemo.service;

import com.example.transactionDemo.model.BankAccount;
import com.example.transactionDemo.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    final private BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount getById(long from) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(from);
        return bankAccount.get();
    }
}
