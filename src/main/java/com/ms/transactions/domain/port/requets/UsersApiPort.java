package com.ms.transactions.domain.port.requets;

import com.ms.transactions.api.dto.wallet.input.WalletDTO;
import com.ms.transactions.domain.model.Transaction;

public interface UsersApiPort {

    WalletDTO withdrawFromWallet(Transaction transaction);
    WalletDTO depositOnWallet(Transaction transaction);
    WalletDTO retrieveWalletFromUserId(Long userId);
}
