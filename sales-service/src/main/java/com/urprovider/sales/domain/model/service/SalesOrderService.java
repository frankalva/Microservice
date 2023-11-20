package com.urprovider.sales.domain.model.service;


import com.urprovider.sales.domain.model.entity.SalesOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalesOrderService {
    List<SalesOrder> getAll();
    SalesOrder getById(Long salesOrderId);


    SalesOrder update(Long salesOrderId, SalesOrder request);
    ResponseEntity<?> delete(Long salesOrderId);
}
