package com.ms.transactions.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
