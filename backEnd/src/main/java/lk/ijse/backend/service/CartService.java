package lk.ijse.backend.service;

import lk.ijse.backend.DTO.CartDTO;

public interface CartService {
    int save (CartDTO cartDTO);
    int update (CartDTO cartDTO);
    int delete (long cartId);
    int deleteByUserId (long userId);
    int deleteByShopId (long shopId);
    int deleteByUserIdAndCartId (long userId, long cartId);

}
