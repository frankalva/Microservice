package com.urprovider.users.store.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("storeMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public StoreMapper storeMapper() {
        return new StoreMapper();
    }
}