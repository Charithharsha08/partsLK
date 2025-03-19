package lk.ijse.backend.repo;

import lk.ijse.backend.entity.OrderedItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDetailRepository extends JpaRepository<OrderedItemDetail, Long> {
}
