package com.urprovider.inventory.service;


import com.urprovider.inventory.domain.model.entity.Product;
import com.urprovider.inventory.domain.persistence.ProductRepository;
import com.urprovider.inventory.domain.service.ProductService;
import com.urprovider.inventory.shared.exception.ResourceNotFoundException;
import com.urprovider.inventory.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

   private static final String ENTITY = "Product";
   private final ProductRepository productRepository;
    private final Validator validator;
    public ProductServiceImpl(ProductRepository productRepository, Validator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, productId));
    }

    @Override
    public Product getByNameAndSupplierId(Product name, Long id) {
        return null;
    }

    //post

    @Override
    public Product update(Long productId, Product request) {
        Set<ConstraintViolation<Product>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
    }



    @Override
    public ResponseEntity<?> delete(Long productId) {
        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build(); })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
    }

    @Override
    public Product create(Product product){
        System.out.println("Fecha de creación antes de guardar: " + product.getCreatedAt());
        Set<ConstraintViolation<Product>> violations= validator.validate(product);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getByIdSupplier(Long supplierId) {
        List<Product> products = productRepository.findByIdSupplier(supplierId);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Product"+ "No products found for supplier with id: " + supplierId);
        }
        return products;
    }
}
