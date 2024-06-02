package com.ms.transactions.api.controller;

import com.ms.transactions.api.assembler.MapperDTO;
import com.ms.transactions.api.dto.transaction.input.TransactionInputDTO;
import com.ms.transactions.api.dto.transaction.output.TransactionDTO;
import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.service.TransactionServicePort;
import com.ms.transactions.infra.adapter.repository.TransactionRepositoryAccess;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionServicePort transactionService;
    private final TransactionRepositoryAccess transactionRepository;
    private final MapperDTO mapper;


    public TransactionController(TransactionServicePort transactionService, TransactionRepositoryAccess transactionRepository, MapperDTO mapper) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO addTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        var transaction  = mapper.transform(transactionInputDTO, Transaction.class);
        transaction = transactionService.addTransaction(transaction);
        return mapper.transform(transaction, TransactionDTO.class);
    }

    @GetMapping("/{transactionId}")
    public  TransactionDTO findById(@PathVariable Long transactionId){
        return mapper.transform(transactionService.findTransactionById(transactionId), TransactionDTO.class);
    }
}
