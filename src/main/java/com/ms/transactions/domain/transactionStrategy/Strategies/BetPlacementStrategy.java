package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.api.dto.transaction.input.BetTransactionDTO;
import com.ms.transactions.api.dto.wallet.input.WalletDTO;
import com.ms.transactions.domain.adapter.service.BetApi;
import com.ms.transactions.domain.adapter.service.WalletApi;
import com.ms.transactions.domain.model.Transaction;

public class BetPlacementStrategy implements TransactionTypeStrategy {


    private final WalletApi walletApi;
    private final BetApi betApi;

    public BetPlacementStrategy(WalletApi walletApi, BetApi betApi) {
        this.walletApi = walletApi;
        this.betApi = betApi;
    }

    public boolean validate(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The withdrawal amount must be positive");
        }

        WalletDTO wallet = walletApi.retrieveWalletFromUserId(transaction.getUserId());
        if (wallet.getBalance() < transaction.getAmount()) {
            throw new IllegalArgumentException("The withdrawal amount must be greater than " +
                    "or equal to the current amount on the user's wallet");
        }

        return true;
    }

    @Override
    public void makeExchange(Transaction transaction) {
        if (validateOnExchange(transaction))
            walletApi.withdrawFromWallet(transaction);
    }

    @Override
    public void execute(Transaction transaction) {
        makeExchange(transaction);
    }

    private boolean validateOnExchange(Transaction transaction) {
        BetTransactionDTO bet = betApi.retrieveBetTransactionFromUserId(transaction.getBetId());
        if (bet.amount() != transaction.getAmount()) {
            throw new IllegalArgumentException("The amount of bet must be equal to the current " +
                    "amount on the user's wallet");
        }

        return true;
    }
}
