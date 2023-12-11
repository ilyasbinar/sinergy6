package com.example.transactionDemo.service;

import com.example.transactionDemo.model.BankAccount;
import org.springframework.stereotype.Service;

public interface BankAccountService {
    BankAccount getById(long from);
}
