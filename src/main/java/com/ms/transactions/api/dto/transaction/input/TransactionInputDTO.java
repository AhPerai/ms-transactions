package com.ms.transactions.api.dto.transaction.input;

import com.ms.transactions.domain.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransactionInputDTO{
    @Positive double amount;
    @NotNull TransactionType transactionType;
    @NotNull Long userId;
    @NotNull Long betId;
}
