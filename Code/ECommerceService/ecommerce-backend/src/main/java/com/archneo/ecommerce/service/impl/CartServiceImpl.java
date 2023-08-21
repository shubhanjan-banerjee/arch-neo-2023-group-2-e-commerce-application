package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.Cart;
import com.archneo.ecommerce.repository.CartRepository;
import com.archneo.ecommerce.service.CartService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Page<Cart> getAllCarts(MultiValueMap<String, String> params, Pageable pageable) {
        // Extract filter parameters from params
        String customerId = params.getFirst("customerId"); // Example filter parameter
        
        // You can add more filter parameters based on your requirements
        
        // Use the filter parameters to create a query specification
        // This is a simplified example; you might need more complex logic
        Specification<Cart> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if (customerId != null) {
                predicates.add(criteriaBuilder.equal(root.get("customer").get("customerId"), customerId));
            }
            
            // Add more predicates based on other filter parameters
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        
        // Fetch data using the created specification and pageable
        return cartRepository.findAll(specification, pageable);
    }

    @Override
    public Cart getCartById(int cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(int cartId, Cart cart) {
        if (cartRepository.existsById(cartId)) {
            cart.setCartId(cartId);
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }
}
