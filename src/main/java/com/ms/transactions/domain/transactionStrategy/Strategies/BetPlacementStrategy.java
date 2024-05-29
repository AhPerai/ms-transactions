package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public class BetPlacementStrategy implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe

        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The bet amount must be positive");
        }

        //TODO: validar se há fundos o suficientes para colocar em determinada aposta
    }

    @Override
    public void execute(Transaction transaction) {

    }
}
