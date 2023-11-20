package com.urprovider.shared.mapping;

import com.urprovider.shipping.mapping.ShipmentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public ShipmentMapper shipmentMapper(){ return new ShipmentMapper();}
}
