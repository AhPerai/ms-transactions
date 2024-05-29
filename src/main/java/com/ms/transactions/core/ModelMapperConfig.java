package com.ms.transactions.core;

import com.ms.transactions.api.dto.transaction.input.TransactionInputDTO;
import com.ms.transactions.domain.model.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.registerModule(new RecordModule());

        /*mapper.createTypeMap(TransactionInputDTO.class, Transaction.class)
                .<Long>addMapping(
                        src -> src.userId(),
                        (dest, value) -> dest.setUserId(value)
                )
                .<Long>addMapping(
                        src -> src.betId(),
                        (dest, value) -> dest.setBetId(value)
                        );*/
        return mapper;
    }
}
