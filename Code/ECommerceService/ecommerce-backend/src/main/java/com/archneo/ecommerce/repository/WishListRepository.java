package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.WishList;

import java.util.List;

import com.archneo.ecommerce.model.WishListId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, WishListId> {
	List<WishList> findByCustomerId(Integer customerId,Pageable pageable);

	void deleteAllByCustomerId(int customerId);



}
