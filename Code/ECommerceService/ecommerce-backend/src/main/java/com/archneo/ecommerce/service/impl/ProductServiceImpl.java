package com.archneo.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.archneo.ecommerce.model.Product;
import com.archneo.ecommerce.repository.ProductRepository;
import com.archneo.ecommerce.service.ProductService;

@Service
//@Transactional --- Not required, as spring boot by default do it
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	/*
	 * Two types of dependency injection: 1. Setter Based (when have optional parameters), 2. Constructor based (when have mandatory parameters)
	 * @Autowired --- Not required, as spring boot by default do it while having single constructor
	 * */
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
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

}
