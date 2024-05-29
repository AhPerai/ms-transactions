package com.ms.transactions.domain.model;

import com.ms.transactions.domain.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private double amount;
    private TransactionType type;
    private LocalDateTime dateTime;
    private Long idBet;
    private Long idUser;

    public Transaction () {}

    public Transaction(Long id, double amount, TransactionType type, LocalDateTime dateTime, Long idBet, Long idUser) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.dateTime = dateTime;
        this.idBet = idBet;
        this.idUser = idUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getIdBet() {
        return idBet;
    }

    public void setIdBet(Long idBet) {
        this.idBet = idBet;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
