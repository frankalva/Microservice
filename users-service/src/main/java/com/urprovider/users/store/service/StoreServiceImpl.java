package com.urprovider.users.store.service;

import com.urprovider.users.shared.exception.ResourceNotFoundException;
import com.urprovider.users.shared.exception.ResourceValidationException;
import com.urprovider.users.store.domain.model.entity.Store;
import com.urprovider.users.store.domain.persistence.StoreRepository;
import com.urprovider.users.store.domain.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class StoreServiceImpl implements StoreService {
    private static final String ENTITY = "Store";

    private final StoreRepository storeRepository;

    private final Validator validator;

    public StoreServiceImpl(StoreRepository storeRepository, Validator validator) {
        this.storeRepository=storeRepository;
        this.validator= validator;

    }
    @Override
    public List<Store> getAll() {return storeRepository.findAll();}

    @Override
    public Page<Store> getAll(Pageable pageable){return storeRepository.findAll(pageable);}

    @Override
    public Store getById(Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, storeId));
    }

    @Override
    public Store create(Store store){
        Set<ConstraintViolation<Store>> violations = validator.validate(store);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        // Email Uniqueness validation
        Store storeWithEmail = storeRepository.findByEmail(store.getEmail());
        if (storeWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A store with the same email already exist.");

        return storeRepository.save(store);
    }



    @Override
    public ResponseEntity<?> delete(Long storeId) {
        return storeRepository.findById(storeId).map(store -> {
                    storeRepository.delete(store);
                    return ResponseEntity.ok().build(); })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, storeId));

    }


}
