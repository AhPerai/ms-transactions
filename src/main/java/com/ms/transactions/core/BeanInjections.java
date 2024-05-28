package com.ms.transactions.core;

import com.ms.transactions.domain.adapter.service.TransactionService;
import com.ms.transactions.domain.port.repository.TransactionRepositoryPort;
import com.ms.transactions.domain.port.service.TransactionServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjections {

    @Bean
    public TransactionServicePort transactionService(TransactionRepositoryPort transactionRepository) {
        return new TransactionService(transactionRepository);
    }
}