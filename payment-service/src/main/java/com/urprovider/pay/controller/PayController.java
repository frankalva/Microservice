package com.urprovider.pay.controller;


import com.urprovider.pay.domain.model.service.PayService;
import com.urprovider.pay.mapping.PayMapper;
import com.urprovider.pay.resource.PayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pays")
public class PayController {

    private final PayService payService;

    private final PayMapper mapper;
    public PayController(PayService payService, PayMapper mapper){
        this.payService = payService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PayResource> getAllPay(){
        return mapper.modelListPage(payService.getAll());
    }
    @GetMapping("{payId}")
    public PayResource getPayById(@PathVariable Long payId){
        return mapper.toResource(payService.getById(payId));
    }


    @GetMapping("/supplier/{supplierId}")
    public PayResource getPayBySupplierId(@PathVariable Long supplierId){
        return mapper.toResource(payService.getBySupplierId(supplierId));
    }

    @GetMapping("/shop/{shopId}")
    public PayResource getPayByShopId(@PathVariable Long shopId){
        return mapper.toResource(payService.getByShopId(shopId));
    }

    @PostMapping
    public PayResource createPay( @Valid @RequestBody PayResource resource){
        return mapper.toResource(payService.create(mapper.toModel(resource)));
    }

}
