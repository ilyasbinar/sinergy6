package com.example.transactionDemo.repository;

import com.example.transactionDemo.model.LogTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTransactionRepository extends JpaRepository<LogTransaction, Long> {
}
