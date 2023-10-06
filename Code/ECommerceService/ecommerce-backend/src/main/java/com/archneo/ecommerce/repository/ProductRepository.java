package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByProductNameContainingIgnoreCase(String productName, Pageable pageable);
    Page<Product> findByPrice(Integer priceValue, Pageable pageable);
    Page<Product> findByCategoryCategoryId(Integer categoryId, Pageable pageable);
}
