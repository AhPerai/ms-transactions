package com.ms.transactions.domain.port.requets;

import com.ms.transactions.api.dto.transaction.input.BetTransactionDTO;

public interface BetApiPort {

    BetTransactionDTO retrieveBetTransactionFromUserId(Long betId);

}
