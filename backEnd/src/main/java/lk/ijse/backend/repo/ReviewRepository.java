package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review , String> {
}
