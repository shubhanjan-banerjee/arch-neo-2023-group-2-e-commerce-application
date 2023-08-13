package com.archneo.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archneo.ecommerce.model.Product;
import com.archneo.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	// create product REST API
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	// get all products REST API
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}

}
