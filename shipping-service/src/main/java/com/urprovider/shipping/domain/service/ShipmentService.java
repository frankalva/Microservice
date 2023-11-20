package com.urprovider.shipping.domain.service;

import com.urprovider.shipping.domain.entity.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShipmentService {

    List<Shipment> getAll();
    Shipment getById(Long shipmentId);


    Shipment getBySupplierId(Long supplierId);

    Shipment getByShopId(Long shopId);

    Shipment getByTrackingNumber(Long trackingNumber);
    Shipment create(Shipment shipment);
}
