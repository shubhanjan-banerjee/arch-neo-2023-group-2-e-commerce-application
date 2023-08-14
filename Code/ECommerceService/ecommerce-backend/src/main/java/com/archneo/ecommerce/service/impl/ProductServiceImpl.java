package com.archneo.ecommerce.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.archneo.ecommerce.exception.ResourceNotFoundException;
import com.archneo.ecommerce.model.Product;
import com.archneo.ecommerce.repository.ProductRepository;
import com.archneo.ecommerce.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));
    }

    @Override
    public void deleteProduct(int productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Product not found with ID: " + productId);
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        return productRepository.findByProductNameContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public Page<Product> filterProductsByCategory(int categoryId, Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Product> filterProductsByBrand(String brand, Pageable pageable) {
        return productRepository.findByBrandIgnoreCase(brand, pageable);
    }

    @Override
    public Page<Product> filterAndSearchProducts(int categoryId, String brand, String keyword, Pageable pageable) {
        return productRepository.findByCategoryIdAndBrandContainingIgnoreCaseAndProductNameContainingIgnoreCase(
                categoryId, brand, keyword, pageable);
    }
    
    @Override
    public Page<Product> getAllProductsSortedBy(String sortBy, Pageable pageable) {
        Sort sort = Sort.by(sortBy);
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Product> productsPage = productRepository.findAll(sortedPageable);

        List<Product> productsList = productsPage.getContent().stream()
                .map(Product::new) // Use your Product constructor here
                .collect(Collectors.toList());

        return new PageImpl<Product>(productsList, sortedPageable, productsPage.getTotalElements());
    }

}
