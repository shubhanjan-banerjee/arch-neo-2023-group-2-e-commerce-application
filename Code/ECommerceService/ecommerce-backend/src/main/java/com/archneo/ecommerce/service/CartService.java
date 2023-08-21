package com.archneo.ecommerce.service;

import com.archneo.ecommerce.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

public interface CartService {
    Page<Cart> getAllCarts(MultiValueMap<String, String> params, Pageable pageable);
    Cart getCartById(int cartId);
    Cart createCart(Cart cart);
    Cart updateCart(int cartId, Cart cart);
    void deleteCart(int cartId);
}
