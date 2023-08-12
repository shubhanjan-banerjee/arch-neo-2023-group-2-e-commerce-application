package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", unique = true)
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url", unique = true)
    private String imageUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "display_order")
    private int displayOrder;

    @Column(name = "slug")
    private String slug;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "meta_keywords")
    private String metaKeywords;

    @Column(name = "custom_attributes")
    private String customAttributes;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Constructors, getters, setters, and other methods...
}
