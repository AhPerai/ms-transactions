package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public interface TransactionTypeStrategy {
    boolean validate(Transaction transaction);
    void makeExchange(Transaction transaction);
    void execute(Transaction transaction);
}

