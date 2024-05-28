package com.ms.transactions.domain.transactionStrategy;

import com.ms.transactions.domain.model.Transaction;

public interface TransactionTypeStrategy {
    void validate(Transaction transaction);
}

class DepositValidator implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        if(transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The amount must be positive to make a deposit transaction");
        }
    }
}

class WithdrawValidator implements TransactionTypeStrategy {
    public void validate(Transaction transaction) {
        if(transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The withdrawal amount must be positive");
        }
        /*TODO: Fazer uma chamada à API de usuários para recuperar a quantia que há na carteira
         *  e saber se há saldo o suficiente para sacar*/
    }
}
class BetPlacementValidator implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe

        if(transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The bet amount must be positive");
        }

        //TODO: validar se há fundos o suficientes para colocar em determinada aposta
    }
}
class BetWinningsValidator implements TransactionTypeStrategy {

    public void validate(Transaction transaction) {
        //TODO: É preciso validar se a aposta de fato existe
        //TODO: É preciso validar se a carteira de fato existe
    }
}