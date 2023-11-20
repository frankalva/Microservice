package com.urprovider.inventory.controller;


import com.urprovider.inventory.domain.model.entity.Product;
import com.urprovider.inventory.domain.service.ProductService;
import com.urprovider.inventory.mapping.ProductMapper;
import com.urprovider.inventory.resource.CreateProductResource;
import com.urprovider.inventory.resource.ProductResource;
import com.urprovider.inventory.resource.UpdateProductResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@EnableEurekaClient
//@EnableDiscoveryClient
@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductsController {

    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductsController(ProductService productService, ProductMapper mapper){
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ProductResource> getAllProducts(){
        return mapper.modelListPage(productService.getAll());
    }

    // no es necesaria este endpoint
    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {

        return new ResponseEntity<>(mapper.toResource(productService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ProductResource updateProduct(@PathVariable Long productId,
                                         @RequestBody UpdateProductResource resource) {
        return mapper.toResource(productService.update(productId, mapper.toModel(resource)));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productService.delete(productId);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Product>> getProductsBySupplier(@PathVariable Long supplierId) {
        List<Product> products = productService.getByIdSupplier(supplierId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
