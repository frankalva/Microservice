package com.urprovider.sales.mapping;


import com.urprovider.sales.domain.model.entity.SalesOrder;
import com.urprovider.sales.resource.CreateSalesOrderResource;
import com.urprovider.sales.resource.SalesOrderResource;
import com.urprovider.sales.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SalesOrderMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public SalesOrderResource toResource(SalesOrder model) {
        return mapper.map(model, SalesOrderResource.class);
    }

    public List<SalesOrderResource> modelListPage(List<SalesOrder> modelList) {
        return mapper.mapList(modelList, SalesOrderResource.class);
    }
    public SalesOrder toModel(CreateSalesOrderResource resource) { return mapper.map(resource, SalesOrder.class); }
}
