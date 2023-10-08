package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "wish_list")
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(WishListId.class)
public class WishList {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

	@Id
	@ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date modifiedAt;

	public WishList() {
		super();
	}

	public WishList(Customer customer, Product product, Date createdAt, Date modifiedAt) {
		super();
		this.customer = customer;
		this.product = product;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
