package com.urprovider.sales.domain.model.service;

import com.urprovider.sales.domain.model.entity.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();
    Review getById(Long reviewId);


    Review update(Long reviewId, Review request);
    ResponseEntity<?> delete(Long reviewId);
}
