package com.urprovider.users.supplier.domain.service;


import com.urprovider.users.supplier.domain.model.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAll();
    Page<Supplier> getAll(Pageable pageable);
    Supplier getById(Long supplierId);
    Supplier create(Supplier supplier);
    Supplier update(Long supplierId, Supplier request);
    ResponseEntity<?> delete(Long supplierId);




}
