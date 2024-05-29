package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public class BetPlacementStrategy implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe
    }

    @Override
    public void execute(Transaction transaction) {

    }
}
