package com.ms.transactions.infra.consumer;

import com.ms.transactions.api.assembler.MapperDTO;
import com.ms.transactions.api.dto.transaction.input.BetTransactionDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    private final MapperDTO mapper;

    public TransactionConsumer(MapperDTO mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = "${broker.queue.transaction.name}")
    public void listenTransactionQueue(@Payload BetTransactionDTO betTransactionDTO){
        System.out.println(betTransactionDTO);
    }

}
