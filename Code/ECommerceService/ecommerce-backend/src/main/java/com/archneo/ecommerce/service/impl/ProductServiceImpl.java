package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.Product;
import com.archneo.ecommerce.repository.ProductRepository;
import com.archneo.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProducts(String searchKeyword, Pageable pageable) {
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            return productRepository.findByProductNameContainingIgnoreCase(searchKeyword, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product existingProduct = getProductById(productId);
        if (existingProduct != null) {
            product.setProductId(existingProduct.getProductId());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
