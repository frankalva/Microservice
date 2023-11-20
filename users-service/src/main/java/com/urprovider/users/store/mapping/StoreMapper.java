package com.urprovider.users.store.mapping;


import com.urprovider.users.shared.mapping.EnhancedModelMapper;
import com.urprovider.users.store.domain.model.entity.Store;
import com.urprovider.users.store.resource.CreateStoreResource;
import com.urprovider.users.store.resource.StoreResource;
import com.urprovider.users.store.resource.UpdateStoreResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class StoreMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public StoreResource toResource(Store model) {
        return mapper.map(model, StoreResource.class);
    }
    public Page<StoreResource> modelListPage(List<Store> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, StoreResource.class), pageable, modelList.size());
    }
    public List<StoreResource> modelListPage(List<Store> modelList) {
        return mapper.mapList(modelList, StoreResource.class);
    }


    public Store toModel(CreateStoreResource resource) {
        return mapper.map(resource, Store.class);
    }

    public Store toModel(UpdateStoreResource resource) {
        return mapper.map(resource, Store.class);
    }
}
