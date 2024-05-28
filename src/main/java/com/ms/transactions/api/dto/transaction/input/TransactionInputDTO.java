package com.ms.transactions.api.dto.transaction.input;

import com.ms.transactions.domain.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TransactionInputDTO(@NotBlank @Positive double amount,
                                  @NotBlank String transactionType,
                                  String idBet) {
}
