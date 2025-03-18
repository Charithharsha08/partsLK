package lk.ijse.backend.service;


import lk.ijse.backend.DTO.ShopDTO;

public interface ShopService {
     int saveShop(ShopDTO shopDTO);
     ShopDTO searchShop(String shopName);
     int deleteShop(long shopId);
     int updateShop(ShopDTO shopDTO);
}
