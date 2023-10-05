package com.archneo.ecommerce.service;

import com.archneo.ecommerce.model.Category;
import com.archneo.ecommerce.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> getAllCategories(String searchKeyword, Pageable pageable);
    
    Page<Product> getAllProductsByCategoryId(Integer categoryId, Pageable pageable);

    Category getCategoryById(int categoryId);

    Category createCategory(Category category);

    Category updateCategory(int categoryId, Category category);

    void deleteCategory(int categoryId);
}
