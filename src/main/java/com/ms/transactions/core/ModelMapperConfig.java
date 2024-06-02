package com.ms.transactions.core;

import com.ms.transactions.api.dto.transaction.input.TransactionInputDTO;
import com.ms.transactions.domain.model.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.registerModule(new RecordModule());

        mapper.addMappings(new PropertyMap<TransactionInputDTO, Transaction>() {
            @Override
            protected void configure() {
                // Ignorar a propriedade id
                skip(destination.getId());
                //Mapear fields corretamente
                map().setUserId(source.getUserId());
                map().setBetId(source.getBetId());
            }
        });

        return mapper;
    }
}
