package com.urprovider.shipping.mapping;

import com.urprovider.shared.mapping.EnhancedModelMapper;
import com.urprovider.shipping.domain.entity.Shipment;
import com.urprovider.shipping.resource.ShipmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ShipmentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;
    public ShipmentResource toResource(Shipment model) {
        return mapper.map(model, ShipmentResource.class);
    }

    public Page<ShipmentResource> modelListPage(List<Shipment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ShipmentResource.class), pageable, modelList.size());
    }

    public List<ShipmentResource> modelListPage(List<Shipment> modelList) {
        return mapper.mapList(modelList, ShipmentResource.class);
    }

    public  Shipment toModel(ShipmentResource resource) {
        return mapper.map(resource, Shipment.class);
    }
}
