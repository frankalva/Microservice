package com.urprovider.users.supplier.mapping;


import com.urprovider.users.shared.mapping.EnhancedModelMapper;
import com.urprovider.users.supplier.domain.model.entity.Supplier;
import com.urprovider.users.supplier.resource.CreateSupplierResource;
import com.urprovider.users.supplier.resource.SupplierResource;
import com.urprovider.users.supplier.resource.UpdateSupplierResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class SupplierMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    //Object Mapping
    //public SupplierResource
    //public Supplier toModel(CreateSupplierResource resource){  }
    public SupplierResource toResource(Supplier model) {
        return mapper.map(model, SupplierResource.class);
    }
    public List<SupplierResource> modelListPage(List<Supplier> modelList) {
        return mapper.mapList(modelList, SupplierResource.class);
    }

    public Supplier toModel(CreateSupplierResource resource) {
        return mapper.map(resource, Supplier.class);
    }

    public Supplier toModel(UpdateSupplierResource resource) {
        return mapper.map(resource, Supplier.class);
    }



}
