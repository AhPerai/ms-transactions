package com.ms.transactions.infra.adapter.repository;

import com.ms.transactions.api.assembler.MapperDTO;
import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.repository.TransactionRepositoryPort;
import com.ms.transactions.infra.adapter.model.TransactionModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionRepository implements TransactionRepositoryPort {

    private final TransactionRepositoryAccess transactionRepositoryAccess;
    private final MapperDTO mapper;

    public TransactionRepository(TransactionRepositoryAccess transactionRepositoryAccess, MapperDTO mapper) {
        this.transactionRepositoryAccess = transactionRepositoryAccess;
        this.mapper = mapper;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var transactionModel = mapper.transform(transaction, TransactionModel.class);
        transactionModel = transactionRepositoryAccess.save(transactionModel);
        transaction = mapper.transform(transactionModel, Transaction.class);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        var transactionModel = transactionRepositoryAccess.findById(id);

        if(transactionModel.isEmpty()) return Optional.empty();

        var transaction = mapper.transform(transactionModel.get(), Transaction.class);
        return Optional.of(transaction);
    }
}
