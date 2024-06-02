package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.api.dto.wallet.output.WalletBalanceDTO;
import com.ms.transactions.domain.adapter.service.WalletApi;
import com.ms.transactions.domain.model.Transaction;
import org.springframework.web.client.RestTemplate;

public class DepositStrategy implements TransactionTypeStrategy {

    private final WalletApi walletApi;

    public DepositStrategy(WalletApi walletApi) {
        this.walletApi = walletApi;
    }

    public boolean validate(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The amount must be positive to make a deposit transaction");
        }

        return true;
    }

    @Override
    public void execute(Transaction transaction) {
        walletApi.depositOnWallet(transaction);
    }
}
