package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , Long> {
    List<Review> findReviewsByShop_ShopId(long shopShopId);
    List<Review> findReviewsByServices_ServiceId(long serviceId);
}
