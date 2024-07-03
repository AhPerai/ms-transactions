package com.ms.transactions.domain.adapter.service;

import com.ms.transactions.api.dto.transaction.output.TransactionDTO;
import com.ms.transactions.api.dto.wallet.input.WalletDTO;
import com.ms.transactions.api.dto.wallet.output.WalletBalanceDTO;
import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.requets.BaseRestClient;
import com.ms.transactions.domain.port.requets.UsersApiPort;
import org.springframework.http.MediaType;

public class WalletApi extends BaseRestClient implements UsersApiPort {

    @Override
    protected void setBaseUrl() {
        BASE_URL = "http://localhost:8081/users/{userId}/wallet";
    }

    @Override
    public WalletDTO withdrawFromWallet(Transaction transaction) {
        WalletBalanceDTO body = new WalletBalanceDTO(transaction.getAmount());

        return restClient.put()
                .uri("/withdraw", transaction.getUserId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(WalletDTO.class);
    }

    @Override
    public WalletDTO depositOnWallet(Transaction transaction) {
        WalletBalanceDTO body = new WalletBalanceDTO(transaction.getAmount());

        return restClient.put()
                .uri("/deposit", transaction.getUserId())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(WalletDTO.class);
    }

    @Override
    public WalletDTO retrieveWalletFromUserId(Long userId) {
        return restClient.get()
                .uri("", userId)
                .retrieve()
                .body(WalletDTO.class);
    }

}
