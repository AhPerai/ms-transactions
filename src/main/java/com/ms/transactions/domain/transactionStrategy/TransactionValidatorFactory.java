package com.ms.transactions.domain.transactionStrategy;
import com.ms.transactions.domain.enums.TransactionType;

public class TransactionValidatorFactory {

    public static TransactionTypeStrategy getTransactionValidator(TransactionType type) {
        switch (type) {
            case DEPOSIT -> { return new DepositValidator();}
            case WITHDRAWAL -> {return new WithdrawValidator();}
            case BET_PLACEMENT -> {return new BetPlacementValidator();}
            case BET_WINNINGS -> {return new BetWinningsValidator();}
        }
        return null;
    }
}

