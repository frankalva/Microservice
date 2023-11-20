package com.urprovider.pay.domain.model.persistence;


import com.urprovider.pay.domain.model.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PayRepository extends JpaRepository<Pay,Long> {

    Optional<Pay> findById (Long id);
    Pay findByDate (Date date);
    Pay findPayBySupplierId (Long supplierId);
    Pay findPayByShopId (Long shopId);
}
