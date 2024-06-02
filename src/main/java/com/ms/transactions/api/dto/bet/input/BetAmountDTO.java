package com.ms.transactions.api.dto.bet.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BetAmountDTO(@NotNull Long idUser, @Positive double amount) {
}
