package com.archneo.ecommerce.service;

import java.util.List;

import com.archneo.ecommerce.model.Product;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product> getProducts();
}
