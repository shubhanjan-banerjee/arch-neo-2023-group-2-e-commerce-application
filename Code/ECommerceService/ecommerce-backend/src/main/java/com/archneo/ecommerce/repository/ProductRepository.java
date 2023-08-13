package com.archneo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archneo.ecommerce.model.Product;

//@Repository --- Not required, as JpaRepository already have
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Define custom query methods if needed
}
