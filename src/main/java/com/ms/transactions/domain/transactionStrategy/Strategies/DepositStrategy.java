package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.api.dto.wallet.output.WalletBalanceDTO;
import com.ms.transactions.domain.model.Transaction;
import org.springframework.web.client.RestTemplate;

public class DepositStrategy implements TransactionTypeStrategy {

    private final RestTemplate restTemplate;
    private final String WALLET_URL = "http://localhost:9081/users/{userId}/wallet/deposit";

    public DepositStrategy() {
        this.restTemplate = new RestTemplate();
    }

    public void validate(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The amount must be positive to make a deposit transaction");
        }
    }

    @Override
    public void execute(Transaction transaction) {

        restTemplate.put(WALLET_URL,
                new WalletBalanceDTO(transaction.getAmount()),
                transaction.getUserId());

    }
}
