package com.ms.transactions.infra.adapter.repository;

import com.ms.transactions.infra.adapter.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositoryAccess extends JpaRepository<TransactionModel, Long> {}
