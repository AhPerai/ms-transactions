package com.ms.transactions.domain.transactionStrategy;

import com.ms.transactions.domain.enums.TransactionType;
import com.ms.transactions.domain.transactionStrategy.Strategies.*;

public class TransactionStrategyFactory {

    public static TransactionTypeStrategy getTransactionValidator(TransactionType type) {
        switch (type) {
            case DEPOSIT -> new DepositStrategy();
            case WITHDRAWAL -> new WithdrawStrategy();
            case BET_PLACEMENT -> new BetPlacementStrategy();
            case BET_WINNINGS -> new BetWinningsStrategy();
        }
        return null;
    }
}

