package lk.ijse.backend.service;

import lk.ijse.backend.DTO.CartDTO;
import lk.ijse.backend.DTO.UserDTO;
import lk.ijse.backend.entity.Cart;

import java.util.List;

public interface CartService {
    int saveCart (CartDTO cartDTO);
    int updateCart (CartDTO cartDTO);
    int deleteCartByUser (UserDTO userDTO);
    int deleteItemById (long cartId);
    List<CartDTO> getAllCartsByUser (UserDTO userDTO);

}
