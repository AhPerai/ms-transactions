package com.ms.transactions.domain.adapter.service;

import com.ms.transactions.api.dto.transaction.input.BetTransactionDTO;
import com.ms.transactions.domain.port.requets.BaseRestClient;
import com.ms.transactions.domain.port.requets.BetApiPort;

public class BetApi extends BaseRestClient implements BetApiPort {

    @Override
    protected void setBaseUrl() {
        BASE_URL = "http://localhost:8081/bets";
    }

    @Override
    public BetTransactionDTO retrieveBetTransactionFromUserId(Long betId) {
        return restClient.get()
                .uri("/{betId}", betId)
                .retrieve()
                .body(BetTransactionDTO.class);
    }
}
