package com.urprovider.sales;

import com.urprovider.sales.domain.model.entity.Review;
import com.urprovider.sales.domain.model.entity.SalesOrder;
import com.urprovider.sales.domain.model.persistence.ReviewRepository;
import com.urprovider.sales.domain.model.persistence.SalesOrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalesApplicationTests {

    @Mock
    private SalesOrderRepository salesOrderRepository;
    @Mock
    private ReviewRepository reviewRepository;
    @Test
    public void ReviewController() {
    }

    @Test
    public void ReviewCreateController(){
        Review review = Review.builder()
                .score(30)
                .title("Revision")
                .description("Comentario")
                .build();
        reviewRepository.save(review);
    }

}
