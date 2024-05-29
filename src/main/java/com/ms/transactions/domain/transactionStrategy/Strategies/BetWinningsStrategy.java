package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.domain.model.Transaction;

public class BetWinningsStrategy implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe
        //TODO: É preciso validar se a carteira de fato existe
    }

    public void execute(Transaction transaction) {

    }
}
