package com.ms.transactions.domain.port.service;

import com.ms.transactions.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionServicePort {

    Transaction addTransaction(Transaction transaction);

    Transaction findTransactionById(Long id);;
}
