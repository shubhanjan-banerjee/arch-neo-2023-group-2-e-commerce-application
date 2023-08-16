package com.archneo.ecommerce.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.archneo.ecommerce.model.Product;
import com.archneo.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProducts(
            @RequestParam String keyword,
            Pageable pageable
    ) {
        Page<Product> products = productService.searchProducts(keyword, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Product>> filterProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String brand,
            Pageable pageable
    ) {
        if (categoryId != null) {
            Page<Product> products = productService.filterProductsByCategory(categoryId, pageable);
            return ResponseEntity.ok(products);
        } else if (brand != null) {
            Page<Product> products = productService.filterProductsByBrand(brand, pageable);
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/filter-search")
    public ResponseEntity<Page<Product>> filterAndSearchProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String keyword,
            Pageable pageable
    ) {
        Page<Product> products = productService.filterAndSearchProducts(categoryId, brand, keyword, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/sort")
    public ResponseEntity<Page<Product>> getAllProductsSortedBy(
            @RequestParam String sortBy,
            Pageable pageable
    ) {
        Page<Product> products = productService.getAllProductsSortedBy(sortBy, pageable);
        return ResponseEntity.ok(products);
    }
}
