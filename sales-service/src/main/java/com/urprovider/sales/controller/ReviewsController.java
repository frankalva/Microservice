package com.urprovider.sales.controller;


import com.urprovider.sales.domain.model.service.ReviewService;
import com.urprovider.sales.mapping.ReviewMapper;
import com.urprovider.sales.resource.ReviewResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/reviews")
public class ReviewsController {
    private final ReviewService reviewService;
    private final ReviewMapper mapper;

    public ReviewsController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }


    @GetMapping
    public List<ReviewResource> getAllReviews() {
        return mapper.modelListPage(reviewService.getAll());
    }
    @GetMapping("{reviewId}")
    public ReviewResource getReviewById(@PathVariable Long reviewId) {
        return mapper.toResource(reviewService.getById(reviewId));
    }
}
