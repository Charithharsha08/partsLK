package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Cart;
import lk.ijse.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartServiceRepository extends JpaRepository<Cart,Long> {
    boolean deleteCartByUser(User user);
    boolean existsCartByUser(User user);

    List<Cart> findCartsByUser_UserId(UUID userUserId);
}
