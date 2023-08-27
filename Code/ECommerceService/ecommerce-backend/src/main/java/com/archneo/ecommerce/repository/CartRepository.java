package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.Cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    // You can define custom query methods here if needed
	Page<Cart> findAll(Specification<Cart> specification, Pageable pageable);
}
