package com.urprovider.users.supplier.controller;


import com.urprovider.users.supplier.domain.service.SupplierService;
import com.urprovider.users.supplier.mapping.SupplierMapper;
import com.urprovider.users.supplier.resource.CreateSupplierResource;
import com.urprovider.users.supplier.resource.SupplierResource;
import com.urprovider.users.supplier.resource.UpdateSupplierResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/suppliers")
public class SuppliersController {
    private final SupplierService supplierService;
    private final SupplierMapper mapper;

    public SuppliersController(SupplierService supplierService, SupplierMapper mapper) {
        this.supplierService = supplierService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SupplierResource> getAllSuppliers(){
        return mapper.modelListPage(supplierService.getAll());
    }
    @GetMapping("{supplierId}")
    public SupplierResource getSupplierById(@PathVariable Long supplierId) {
        return mapper.toResource(supplierService.getById(supplierId));
    }

    @PostMapping
    public SupplierResource createSupplier(@RequestBody CreateSupplierResource resource) {
        return mapper.toResource(supplierService.create(mapper.toModel(resource)));
    }
    @PutMapping("{supplierId}")
    public SupplierResource updateSupplier(@PathVariable Long supplierId,
                                         @RequestBody UpdateSupplierResource resource) {
        return mapper.toResource(supplierService.update(supplierId, mapper.toModel(resource)));
    }

    @DeleteMapping("{supplierId}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long supplierId) {
        return supplierService.delete(supplierId);
    }
}
