package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.Category;
import com.archneo.ecommerce.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
	Page<Category> findByCategoryNameContainingIgnoreCase(String categoryName, Pageable pageable);
    
    Page<Product> findProductsByCategoryId(Integer categoryId, Pageable pageable);
}
