package com.ms.transactions.api.controller;

import com.ms.transactions.api.assembler.MapperDTO;
import com.ms.transactions.api.dto.transaction.input.TransactionInputDTO;
import com.ms.transactions.api.dto.transaction.output.TransactionDTO;
import com.ms.transactions.domain.model.Transaction;
import com.ms.transactions.domain.port.service.TransactionServicePort;
import com.ms.transactions.infra.adapter.repository.TransactionRepositoryAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @Operation(summary = "Add a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the transaction"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO addTransaction(
            @Parameter(description = "Transaction input data", required = true, content = @Content(schema = @Schema(implementation = TransactionInputDTO.class)))
            @RequestBody TransactionInputDTO transactionInputDTO) {
        var transaction  = mapper.transform(transactionInputDTO, Transaction.class);
        transaction = transactionService.addTransaction(transaction);
        return mapper.transform(transaction, TransactionDTO.class);
    }

    @Operation(summary = "Find transaction by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the transaction"),
            @ApiResponse(responseCode = "404", description = "Transaction not found")
    })
    @GetMapping("/{transactionId}")
    public  TransactionDTO findById(
            @Parameter(description = "Id of the transaction to be retrieved", required = true)
            @PathVariable Long transactionId){
        return mapper.transform(transactionService.findTransactionById(transactionId), TransactionDTO.class);
    }

    @Operation(summary = "Find all transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all transactions"),
            @ApiResponse(responseCode = "404", description = "Transactions not found")
    })
    @GetMapping
    public List<TransactionDTO> findTransactions(){
        return mapper.toCollection(transactionRepository.findAll(), TransactionDTO.class);
    }
}
