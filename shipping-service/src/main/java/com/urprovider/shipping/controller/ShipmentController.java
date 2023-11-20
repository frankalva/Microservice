package com.urprovider.shipping.controller;


import com.urprovider.shipping.domain.service.ShipmentService;
import com.urprovider.shipping.mapping.ShipmentMapper;
import com.urprovider.shipping.resource.ShipmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/shipments", produces = "application/json")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final ShipmentMapper mapper;
    public ShipmentController(ShipmentService shipmentService, ShipmentMapper mapper){
        this.shipmentService = shipmentService;
        this.mapper = mapper;
    }
    @GetMapping
    public List<ShipmentResource> getAllShipment(){
        return mapper.modelListPage(shipmentService.getAll());
    }
    @GetMapping("{shipmentId}")
    public ShipmentResource getShipmentById(@PathVariable Long shipmentId){
        return mapper.toResource(shipmentService.getById(shipmentId));
    }
    @GetMapping("/tracking/{trackingNumber}")
    public ShipmentResource getShipmentByTrackingNumber(@PathVariable Long trackingNumber){
        return mapper.toResource(shipmentService.getByTrackingNumber(trackingNumber));
    }
    @GetMapping("/supplier/{supplierId}")
    public ShipmentResource getShipmentBySupplierId(@PathVariable Long supplierId){
        return mapper.toResource(shipmentService.getBySupplierId(supplierId));
    }
    @GetMapping("/shop/{shopId}")
    public ShipmentResource getShipmentByShopId(@PathVariable Long shopId){
        return mapper.toResource(shipmentService.getByShopId(shopId));
    }
    @PostMapping
    public ShipmentResource createShipment(@Valid @RequestBody ShipmentResource resource){
        return mapper.toResource(shipmentService.create(mapper.toModel(resource)));
    }


}
