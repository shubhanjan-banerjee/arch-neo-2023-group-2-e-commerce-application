package com.archneo.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.archneo.ecommerce.model.Product;

//@Repository --- Not required, as JpaRepository already have
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByProductNameContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Product> findByCategoryCategoryId(int categoryId, Pageable pageable);
    Page<Product> findByBrandIgnoreCase(String brand, Pageable pageable);
    Page<Product> findByCategoryCategoryIdAndBrandContainingIgnoreCaseAndProductNameContainingIgnoreCase(
            int categoryId, String brand, String keyword, Pageable pageable);
}
