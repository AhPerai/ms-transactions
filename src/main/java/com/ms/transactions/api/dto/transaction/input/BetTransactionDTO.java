package com.ms.transactions.api.dto.transaction.input;


import lombok.Getter;

@Getter
public record BetTransactionDTO(Long id, Long idUser, float odds, double amount) {
}
