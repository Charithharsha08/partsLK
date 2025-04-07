package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.CartDTO;
import lk.ijse.backend.DTO.UserDTO;
import lk.ijse.backend.entity.Cart;
import lk.ijse.backend.entity.User;
import lk.ijse.backend.repo.CartServiceRepository;
import lk.ijse.backend.service.CartService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartServiceRepository cartServiceRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int saveCart(CartDTO cartDTO) {
        try {
            if (cartServiceRepository.existsById(cartDTO.getCartId())) {
                return VarList.Conflict;
            }else {
                cartServiceRepository.save(modelMapper.map(cartDTO, Cart.class));
                return VarList.Created;
            }
        } catch (Exception e) {
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public int updateCart(CartDTO cartDTO) {
        if (cartServiceRepository.existsById(cartDTO.getCartId())) {
            cartServiceRepository.save(modelMapper.map(cartDTO, Cart.class));
            return VarList.OK;
        }else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int deleteCartByUser(UserDTO userDTO) {
        if (!cartServiceRepository.existsCartByUser(modelMapper.map(userDTO, User.class))) {
            return VarList.Not_Found;
        }else {
            cartServiceRepository.deleteCartByUser(modelMapper.map(userDTO, User.class));
            return VarList.OK;
        }
    }

    @Override
    public int deleteItemById(long cartId) {
        if (cartServiceRepository.existsById(cartId)) {
            cartServiceRepository.deleteById(cartId);
            return VarList.OK;
        }else {
            return VarList.Not_Found;
        }
    }

    @Override
    public List<CartDTO> getAllCartsByUser(UserDTO userDTO) {
        if (cartServiceRepository.existsCartByUser(modelMapper.map(userDTO, User.class))) {
            return modelMapper.map(cartServiceRepository.findCartByUser(modelMapper.map(userDTO, User.class)), new TypeToken<List<Cart>>(){}.getType());
        }else {
            return null;
        }
    }
}
