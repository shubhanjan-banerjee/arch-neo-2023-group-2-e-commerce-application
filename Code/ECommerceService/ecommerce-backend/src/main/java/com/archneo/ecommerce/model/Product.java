package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "discount")
    private String discount;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private String stockQuantity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "sku")
    private int sku;

    @Column(name = "weight")
    private String weight;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "rating")
    private String rating;

    @Column(name = "reviews_count")
    private String reviewsCount;

    @Column(name = "manufacturer_part_number")
    private String manufacturerPartNumber;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "tax_rate")
    private String taxRate;

    @Column(name = "additional_attributes", columnDefinition = "TEXT")
    private String additionalAttributes;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Getters and setters

    // Constructors

    // Other methods if needed
}
