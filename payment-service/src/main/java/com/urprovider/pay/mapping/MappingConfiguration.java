package com.urprovider.pay.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("payMappingConfiguration")

public class MappingConfiguration {

    @Bean
    public PayMapper payMapper() {
        return new PayMapper();
    }
}
