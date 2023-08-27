package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.Category;
import com.archneo.ecommerce.repository.CategoryRepository;
import com.archneo.ecommerce.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(String searchKeyword, Pageable pageable) {
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            return categoryRepository.findByCategoryNameContainingIgnoreCase(searchKeyword, pageable);
        } else {
            return categoryRepository.findAll(pageable);
        }
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        Category existingCategory = getCategoryById(categoryId);
        if (existingCategory != null) {
            category.setCategoryId(existingCategory.getCategoryId());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
