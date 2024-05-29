package com.ms.transactions.domain.transactionStrategy;

import com.ms.transactions.domain.enums.TransactionType;
import com.ms.transactions.domain.transactionStrategy.Strategies.*;

public class TransactionStrategyFactory {

    public static TransactionTypeStrategy getTransactionValidator(TransactionType type) {
        switch (type) {
            case DEPOSIT -> { return new DepositStrategy(); }
            case WITHDRAWAL -> {return new WithdrawStrategy();}
            case BET_PLACEMENT -> {return new BetPlacementStrategy();}
            case BET_WINNINGS -> {return new BetWinningsStrategy();}
        }
        return null;
    }
}

