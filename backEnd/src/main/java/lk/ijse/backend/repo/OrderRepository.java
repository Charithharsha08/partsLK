package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsOrderByOrderId(long orderId);
    Order findOrderByOrderId(long orderId);
}
