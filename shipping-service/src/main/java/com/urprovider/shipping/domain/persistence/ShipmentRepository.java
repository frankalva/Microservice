package com.urprovider.shipping.domain.persistence;

import com.urprovider.shipping.domain.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findById (Long id);

    Shipment findByTrackingNumber (Long trackingNumber);

    Shipment findShipmentBySuplierId (Long supplierId);

    Shipment findShipmentByShopId (Long shopId);

}
