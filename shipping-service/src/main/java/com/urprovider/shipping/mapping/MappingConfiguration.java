package com.urprovider.shipping.mapping;


import com.urprovider.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("shippingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper(){ return new EnhancedModelMapper();}
}
