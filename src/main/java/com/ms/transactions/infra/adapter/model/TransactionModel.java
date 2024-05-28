package com.ms.transactions.infra.adapter.model;

import com.ms.transactions.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_TRANSACTION")
@Entity
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private LocalDateTime dateTime;
    private Long idBet;
}
