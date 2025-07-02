package org.tcskart.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcskart.productservice.bean.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);

    Optional<Review> findByProductIdAndUserId(Long productId, String userId);
}
