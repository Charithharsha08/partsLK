package lk.ijse.backend.service;

import lk.ijse.backend.DTO.CartDTO;
import lk.ijse.backend.DTO.UserDTO;

public interface CartService {
    int saveCart (CartDTO cartDTO);
    int updateCart (CartDTO cartDTO);
    int deleteCartByUser (UserDTO userDTO);
    int deleteItemById (long cartId);

}
