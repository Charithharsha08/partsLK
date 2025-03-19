package lk.ijse.backend.repo;

import lk.ijse.backend.entity.Item;
import lk.ijse.backend.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
    boolean existsItemByItemName(String itemName);
    Item findItemByItemName(String itemName);

    boolean existsByShop_ShopId(long shopShopId);
}
