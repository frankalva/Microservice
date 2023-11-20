package com.urprovider.shipping.service;


import com.urprovider.shared.exception.ResourceNotFoundException;
import com.urprovider.shared.exception.ResourceValidationException;
import com.urprovider.shipping.domain.entity.Shipment;
import com.urprovider.shipping.domain.persistence.ShipmentRepository;
import com.urprovider.shipping.domain.service.ShipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    private static final String Entity = "Shipment";

    private final ShipmentRepository ShipmentRepository;

    private final Validator validator;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, Validator validator) {
        this.ShipmentRepository = shipmentRepository;
        this.validator = validator;
    }


    @Override
    public List<Shipment> getAll() {
        return ShipmentRepository.findAll();
    }



    @Override
    public Shipment getById(Long shipmentId) {
        return ShipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException(Entity, shipmentId));
    }

    @Override
    public Shipment getBySupplierId(Long supplierId) {
        return ShipmentRepository.findShipmentBySuplierId(supplierId);
    }

    @Override
    public Shipment getByShopId(Long shopId) {
        return ShipmentRepository.findShipmentByShopId(shopId);
    }

    @Override
    public Shipment getByTrackingNumber(Long trackingNumber) {
        return ShipmentRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipment create(Shipment shipment) {
        Set<ConstraintViolation<Shipment>> violations = validator.validate(shipment);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(Entity, violations);
        }
        return ShipmentRepository.save(shipment);
    }
}
