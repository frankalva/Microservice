package com.urprovider.users.store.domain.service;


import com.urprovider.users.store.domain.model.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreService {
    List<Store> getAll();
    Page<Store> getAll(Pageable pageable);
    Store getById(Long storeId);
    Store create(Store store);
    ResponseEntity<?> delete(Long storeId);

}
