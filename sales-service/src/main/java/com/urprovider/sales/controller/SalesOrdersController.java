package com.urprovider.sales.controller;


import com.urprovider.sales.domain.model.service.SalesOrderService;
import com.urprovider.sales.mapping.SalesOrderMapper;
import com.urprovider.sales.resource.SalesOrderResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/salesOrders")
public class SalesOrdersController {

    private final SalesOrderService salesOrderService;
    private final SalesOrderMapper mapper;

    public SalesOrdersController(SalesOrderService salesOrderService, SalesOrderMapper mapper) {
        this.salesOrderService = salesOrderService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SalesOrderResource> getAllSalesOrders() {
        return mapper.modelListPage(salesOrderService.getAll());
    }
    @GetMapping("{salesOrderId}")
    public SalesOrderResource getSalesOrderById(@PathVariable Long salesOrderId) {
        return mapper.toResource(salesOrderService.getById(salesOrderId));
    }
}
