package com.urprovider.sales.domain.model.persistence;

import com.urprovider.sales.domain.model.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
    List<SalesOrder> findAllByStatus(String status);
    SalesOrder findSalesOrderById(Long salesOrderId);
}
