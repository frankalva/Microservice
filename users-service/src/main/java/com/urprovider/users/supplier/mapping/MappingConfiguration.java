package com.urprovider.users.supplier.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("supplierMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public SupplierMapper supplierMapper(){
        return new SupplierMapper();
    }

}
