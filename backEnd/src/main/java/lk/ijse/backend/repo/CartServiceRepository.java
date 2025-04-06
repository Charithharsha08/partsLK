package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartServiceRepository extends JpaRepository<Cart,Long> {
    boolean deleteByUserId(long userId);
    boolean deleteByShopId(long shopId);
    boolean deleteByUserIdAndCartId(long userId, long cartId);

    boolean existsByCartId(long cartId);
}
