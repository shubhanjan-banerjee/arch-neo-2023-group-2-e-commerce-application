package com.archneo.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "wish_list")
@IdClass(WishListId.class)
public class WishList {
	@Id
	@Column(name = "customer_id")
	@JsonInclude
	@JsonProperty("customerId")
	private Integer customerId;

	@Id
	@Column(name = "product_id")
	@JsonProperty("productId")
	private Integer productId;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "modified_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;

	// Constructors, getters, and setters

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
