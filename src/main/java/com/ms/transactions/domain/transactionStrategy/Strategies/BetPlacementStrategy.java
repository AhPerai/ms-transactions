package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public class BetPlacementStrategy implements TransactionTypeStrategy {

    public boolean validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe

        return true;
    }

    @Override
    public void execute(Transaction transaction) {

    }
}
