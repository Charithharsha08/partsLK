package lk.ijse.backend.service.impl;

import lk.ijse.backend.DTO.CartDTO;
import lk.ijse.backend.entity.Cart;
import lk.ijse.backend.repo.CartServiceRepository;
import lk.ijse.backend.service.CartService;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartServiceRepository cartServiceRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int save(CartDTO cartDTO) {
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
    public int update(CartDTO cartDTO) {
        if (cartServiceRepository.existsById(cartDTO.getCartId())) {
            cartServiceRepository.save(modelMapper.map(cartDTO, Cart.class));
            return VarList.OK;
        }else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int delete(long cartId) {
        if (cartServiceRepository.existsById(cartId)) {
            cartServiceRepository.deleteById(cartId);
            return VarList.OK;
        }else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int deleteByUserId(long userId) {
        if (!cartServiceRepository.existsById(userId)) {
            return VarList.Not_Found;
        }else {
            cartServiceRepository.deleteById(userId);
            return VarList.OK;
        }
    }

    @Override
    public int deleteByShopId(long shopId) {
        if (!cartServiceRepository.existsById(shopId)) {
            return VarList.Not_Found;
        }else {
            cartServiceRepository.deleteByShopId(shopId);
            return VarList.OK;
        }
    }

    @Override
    public int deleteByUserIdAndCartId(long userId, long cartId) {
        if (!cartServiceRepository.existsByCartId(cartId)) {
            return VarList.Not_Found;
        }else {
            cartServiceRepository.deleteByUserIdAndCartId(userId,cartId);
            return VarList.OK;
        }
    }
}
