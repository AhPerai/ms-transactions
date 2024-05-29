package com.ms.transactions.domain.transactionStrategy.Strategies;

import com.ms.transactions.api.dto.wallet.input.WalletDTO;
import com.ms.transactions.api.dto.wallet.output.WalletBalanceDTO;
import com.ms.transactions.domain.model.Transaction;
import org.springframework.web.client.RestTemplate;

public class WithdrawStrategy implements TransactionTypeStrategy {

    private final RestTemplate restTemplate;
    private final String WALLET_URL = "http://localhost:9081/users/{userId}/wallet";
    private final String WALLET_URL_WITHDRAW = "http://localhost:9081/users/{userId}/wallet/withdraw";

    public WithdrawStrategy() {
        restTemplate = new RestTemplate();
    }

    @Override
    public void validate(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("The withdrawal amount must be positive");
        }

        WalletDTO wallet = restTemplate.getForObject(WALLET_URL, WalletDTO.class, transaction.getUserId());
        if (wallet.getBalance() < transaction.getAmount()) {
            throw new IllegalArgumentException("The withdrawal amount must be greater than " +
                    "or equal to the current amount on the user's wallet");
        }
    }

    @Override
    public void execute(Transaction transaction) {
        restTemplate.put(WALLET_URL_WITHDRAW,
                new WalletBalanceDTO(transaction.getAmount()),
                transaction.getUserId());
    }

}
