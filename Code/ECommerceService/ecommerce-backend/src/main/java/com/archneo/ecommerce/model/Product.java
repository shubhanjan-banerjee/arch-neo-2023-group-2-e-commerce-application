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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(String reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getAdditionalAttributes() {
		return additionalAttributes;
	}

	public void setAdditionalAttributes(String additionalAttributes) {
		this.additionalAttributes = additionalAttributes;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Product() {
		super();
	}

	public Product(int productId, String productName, String description, Category category, String brand,
			String discount, BigDecimal price, String stockQuantity, String imageUrl, int sku, String weight,
			String isActive, String rating, String reviewsCount, String manufacturerPartNumber, String productUrl,
			String taxRate, String additionalAttributes, Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.discount = discount;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.imageUrl = imageUrl;
		this.sku = sku;
		this.weight = weight;
		this.isActive = isActive;
		this.rating = rating;
		this.reviewsCount = reviewsCount;
		this.manufacturerPartNumber = manufacturerPartNumber;
		this.productUrl = productUrl;
		this.taxRate = taxRate;
		this.additionalAttributes = additionalAttributes;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

    
}
