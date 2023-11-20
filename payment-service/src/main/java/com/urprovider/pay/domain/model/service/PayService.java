package com.urprovider.pay.domain.model.service;

import com.urprovider.pay.domain.model.entity.Pay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PayService {

    List<Pay> getAll();

    Pay getBySupplierId(Long supplierId);

    Pay getByShopId(Long shopId);

    Pay getById(Long payId);

    Pay create(Pay pay);


}
