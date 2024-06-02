package com.ms.transactions.domain.transactionStrategy;

import com.ms.transactions.domain.adapter.service.BetApi;
import com.ms.transactions.domain.adapter.service.WalletApi;
import com.ms.transactions.domain.enums.TransactionType;
import com.ms.transactions.domain.transactionStrategy.Strategies.*;

import static com.ms.transactions.domain.enums.TransactionType.*;

public class TransactionStrategyFactory {

    public static TransactionTypeStrategy getTransactionValidator(TransactionType type) {

        switch (type) {
            case DEPOSIT -> {
                return new DepositStrategy(new WalletApi());
            }
            case WITHDRAWAL -> {
                return new WithdrawStrategy(new WalletApi());
            }
            case BET_PLACEMENT -> {
                return new BetPlacementStrategy(new WalletApi(), new BetApi());
            }
            case BET_WINNINGS -> {
                return new BetWinningsStrategy();
            }
        }
        return null;
    }
}

