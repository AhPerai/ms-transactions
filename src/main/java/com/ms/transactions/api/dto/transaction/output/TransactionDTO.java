package com.ms.transactions.api.dto.transaction.output;

import com.ms.transactions.domain.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private double amount;
    private TransactionType type;
    private LocalDateTime dateTime;
    private Long idBet;
}
