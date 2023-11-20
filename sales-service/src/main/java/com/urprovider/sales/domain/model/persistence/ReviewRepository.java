package com.urprovider.sales.domain.model.persistence;

import com.urprovider.sales.domain.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findReviewById(Long reviewId);

}
