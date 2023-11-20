package com.urprovider.pay.service;

import com.urprovider.shared.exception.ResourceNotFoundException;
import com.urprovider.shared.exception.ResourceValidationException;
import com.urprovider.pay.domain.model.entity.Pay;
import com.urprovider.pay.domain.model.persistence.PayRepository;
import com.urprovider.pay.domain.model.service.PayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PayServiceImpl implements PayService {

    private static final String ENTITY = "Pay";
    private final PayRepository payRepository;

    private final Validator validator;

    public PayServiceImpl(PayRepository payRepository, Validator validator) {
        this.payRepository = payRepository;
        this.validator = validator;
    }

    @Override
    public List<Pay> getAll() {
        return payRepository.findAll();
    }



    @Override
    public Pay getBySupplierId(Long supplierId) {
        return payRepository.findPayBySupplierId(supplierId);
    }

    @Override
    public Pay getByShopId(Long shopId) {
        return payRepository.findPayByShopId(shopId);
    }

    @Override
    public Pay getById(Long payId) {
        return payRepository.findById(payId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, payId));
    }

    @Override
    public Pay create(Pay pay) {
        Set<ConstraintViolation<Pay>> violations = validator.validate(pay);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return payRepository.save(pay);
    }
}
