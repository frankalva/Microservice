package com.urprovider.inventory.domain.service;

import com.urprovider.inventory.domain.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getByNameAndSupplierId(Product name,Long id);

    Product getById(Long productId);

    Product update(Long productId, Product request);
    ResponseEntity<?> delete(Long productId);

    Product create(Product product);

    List<Product> getByIdSupplier(Long supplierId);
}
