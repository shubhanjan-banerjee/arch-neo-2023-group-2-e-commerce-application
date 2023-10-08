package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.WishList;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
	Page<WishList> findAll(Specification<WishList> specification, Pageable pageable);
	WishList findByCustomerIdProductId(int customerId, int productId);
}
