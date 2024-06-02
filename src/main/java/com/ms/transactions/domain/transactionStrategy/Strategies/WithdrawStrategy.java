package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.api.dto.wallet.input.WalletDTO;
import com.ms.transactions.api.dto.wallet.output.WalletBalanceDTO;
import com.ms.transactions.domain.adapter.service.WalletApi;
import com.ms.transactions.domain.model.Transaction;
import org.springframework.web.client.RestTemplate;

public class WithdrawStrategy implements TransactionTypeStrategy {

    private final WalletApi walletApi;

    public WithdrawStrategy(WalletApi walletApi) {
        this.walletApi = walletApi;
    }

    @Override
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
    public void execute(Transaction transaction) {
        walletApi.withdrawFromWallet(transaction);
    }

}
