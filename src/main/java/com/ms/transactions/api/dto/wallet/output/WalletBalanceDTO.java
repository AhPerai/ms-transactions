package com.ms.transactions.api.dto.wallet.output;

import jakarta.validation.constraints.PositiveOrZero;

public record WalletBalanceDTO(@PositiveOrZero double balance) {
}
