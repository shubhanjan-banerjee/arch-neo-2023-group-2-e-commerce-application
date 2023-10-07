package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CATEGORIES")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnore
    private int displayOrder;

    @Column(name = "slug")
    @JsonIgnore
    private String slug;

    @Column(name = "meta_title")
    @JsonIgnore
    private String metaTitle;

    @Column(name = "meta_description")
    @JsonIgnore
    private String metaDescription;

    @Column(name = "meta_keywords")
    @JsonIgnore
    private String metaKeywords;

    @Column(name = "custom_attributes")
    @JsonIgnore
    private String customAttributes;

    @Column(name = "created_at")
    @JsonIgnore
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @JsonIgnore
    private Timestamp modifiedAt;


    public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getCustomAttributes() {
		return customAttributes;
	}

	public void setCustomAttributes(String customAttributes) {
		this.customAttributes = customAttributes;
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


	public Category() {
		super();
	}
	
	public Category(int categoryId, String categoryName, Category parentCategory, String description, String imageUrl,
			boolean isActive, int displayOrder, String slug, String metaTitle, String metaDescription,
			String metaKeywords, String customAttributes, Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
		this.description = description;
		this.imageUrl = imageUrl;
		this.isActive = isActive;
		this.displayOrder = displayOrder;
		this.slug = slug;
		this.metaTitle = metaTitle;
		this.metaDescription = metaDescription;
		this.metaKeywords = metaKeywords;
		this.customAttributes = customAttributes;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;

	}

    // Constructors, getters, setters, and other methods...
    
}
