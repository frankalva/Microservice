package com.urprovider.users.store.controller;


import com.urprovider.users.store.domain.service.StoreService;
import com.urprovider.users.store.mapping.StoreMapper;
import com.urprovider.users.store.resource.CreateStoreResource;
import com.urprovider.users.store.resource.StoreResource;
import com.urprovider.users.store.resource.UpdateStoreResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/stores", produces = "application/json")

public class StoresController {
    private final StoreService storeService;
    private final StoreMapper mapper;
    public StoresController(StoreService storeService, StoreMapper mapper){
        this.storeService = storeService;
        this.mapper = mapper;
    }
    @GetMapping
    public Page<StoreResource> getAllStore(Pageable pageable){
        return mapper.modelListPage(storeService.getAll(), pageable);
    }
    @GetMapping("{storeId}")
    public StoreResource getStoreById(@PathVariable Long storeId){
        return mapper.toResource(storeService.getById(storeId));
    }
    @PostMapping
    public StoreResource createStore(@Valid @RequestBody CreateStoreResource resource){
        return mapper.toResource(storeService.create(mapper.toModel(resource)));
    }
    @DeleteMapping("{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable Long storeId){
        return storeService.delete(storeId);
    }
}
