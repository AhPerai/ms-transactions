package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public interface TransactionTypeStrategy {
    void validate(Transaction transaction);

    void execute(Transaction transaction);
}

