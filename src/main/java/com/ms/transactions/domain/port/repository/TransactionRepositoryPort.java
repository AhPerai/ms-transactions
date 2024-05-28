package com.ms.transactions.domain.port.repository;

import com.ms.transactions.domain.model.Transaction;
import java.util.Optional;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(Long id);
}
