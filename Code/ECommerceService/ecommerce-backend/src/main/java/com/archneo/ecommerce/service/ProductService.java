package com.archneo.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.archneo.ecommerce.model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProductById(int productId);
    List<Product> getProducts();
    void deleteProduct(int productId);
    Page<Product> getAllProducts(Pageable pageable);
    Page<Product> searchProducts(String keyword, Pageable pageable);
    Page<Product> filterProductsByCategory(int categoryId, Pageable pageable);
    Page<Product> filterProductsByBrand(String brand, Pageable pageable);
    Page<Product> filterAndSearchProducts(int categoryId, String brand, String keyword, Pageable pageable);
    Page<Product> getAllProductsSortedBy(String sortBy, Pageable pageable);
}
