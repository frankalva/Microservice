package com.urprovider.users.supplier.service;


import com.urprovider.users.shared.exception.ResourceNotFoundException;
import com.urprovider.users.shared.exception.ResourceValidationException;
import com.urprovider.users.supplier.domain.model.entity.Supplier;
import com.urprovider.users.supplier.domain.persistence.SupplierRepository;
import com.urprovider.users.supplier.domain.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {
    private static final String ENTITY = "Supplier";
    private final SupplierRepository supplierRepository;
    private final Validator validator;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Validator validator ) {
        this.supplierRepository = supplierRepository;
        this.validator = validator;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Page<Supplier> getAll(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier getById(Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, supplierId));
    }

    @Override
    public Supplier create(Supplier supplier) {
        Set<ConstraintViolation<Supplier>> violations = validator.validate(supplier);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        Optional<Supplier> supplierWithEmail = supplierRepository.findByEmail(supplier.getEmail());
        if (supplierWithEmail.isPresent()){
            throw new ResourceValidationException(ENTITY,
                    "A supplier with the same email already exist.");
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Long supplierId, Supplier request) {
        Set<ConstraintViolation<Supplier>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Optional<Supplier> supplierWithEmail = supplierRepository.findByEmail(request.getEmail());

        if(supplierWithEmail.isPresent() && !supplierWithEmail.get().getId().equals(supplierId))
            throw new ResourceValidationException(ENTITY,
                    "A supplier with the same email already exists.");

        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long supplierId) {

        return supplierRepository.findById(supplierId).map(supplier -> {
            supplierRepository.delete(supplier);
            return ResponseEntity.ok().build(); })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, supplierId));

    }



}
