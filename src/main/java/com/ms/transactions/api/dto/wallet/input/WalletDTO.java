package com.ms.transactions.api.dto.wallet.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WalletDTO {
    private Long id;
    private double balance;
    private Long userId;
}