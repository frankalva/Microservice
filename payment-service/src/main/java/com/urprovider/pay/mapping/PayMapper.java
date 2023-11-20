package com.urprovider.pay.mapping;

import com.urprovider.pay.domain.model.entity.Pay;
import com.urprovider.pay.resource.PayResource;
import com.urprovider.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PayMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PayResource toResource(Pay model) {
        return mapper.map(model, PayResource.class);
    }

    public Page<PayResource> modelListPage(List<Pay> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PayResource.class), pageable, modelList.size());
    }
    public List<PayResource> modelListPage(List<Pay> modelList) {
        return mapper.mapList(modelList, PayResource.class);
    }

    public Pay toModel(PayResource resource) {
        return mapper.map(resource, Pay.class);
    }


}
