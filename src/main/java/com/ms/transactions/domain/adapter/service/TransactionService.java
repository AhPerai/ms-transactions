package com.ms.transactions.domain.adapter.service;

import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.repository.TransactionRepositoryPort;
import com.ms.transactions.domain.port.service.TransactionServicePort;
import com.ms.transactions.domain.transactionStrategy.Strategies.TransactionTypeStrategy;
import com.ms.transactions.domain.transactionStrategy.TransactionStrategyFactory;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionService implements TransactionServicePort {

    private final TransactionRepositoryPort transactionRepository;

    public TransactionService(TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        TransactionTypeStrategy transactionType = this.getTransactionTypeStrategy(transaction);

        transactionType.execute(transaction);
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }


    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean validateTransaction(Transaction transaction) {
        TransactionTypeStrategy transactionType = this.getTransactionTypeStrategy(transaction);
        return transactionType.validate(transaction);
    }


    private TransactionTypeStrategy getTransactionTypeStrategy(Transaction transaction) {
        TransactionTypeStrategy strategy = TransactionStrategyFactory.getTransactionValidator(transaction.getType());

        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("The transaction type is not supported");
        }

        return strategy;
    }
}
