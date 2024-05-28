package com.ms.transactions.domain.adapter.service;

import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.repository.TransactionRepositoryPort;
import com.ms.transactions.domain.port.service.TransactionServicePort;
import com.ms.transactions.domain.transactionStrategy.TransactionTypeStrategy;
import com.ms.transactions.domain.transactionStrategy.TransactionValidatorFactory;
import jakarta.persistence.EntityNotFoundException;
import java.util.Objects;

public class TransactionService implements TransactionServicePort {

    private final TransactionRepositoryPort transactionRepository;

    public TransactionService(TransactionRepositoryPort transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        TransactionTypeStrategy transactionType = this.getTransactionTypeStrategy(transaction);
        transactionType.validate(transaction);

        //TODO: provavelmente haverão regras de negócio atrelada a carteira do usuário à serem implementadas
        return transactionRepository.save(transaction);
    }


    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    private TransactionTypeStrategy getTransactionTypeStrategy(Transaction transaction) {
        TransactionTypeStrategy strategy = TransactionValidatorFactory.getTransactionValidator(transaction.getType());

        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("The transaction type is not supported");
        }

        return strategy;
    }
}
