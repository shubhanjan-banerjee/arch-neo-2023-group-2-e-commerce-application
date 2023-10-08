package com.archneo.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

public class WishListId implements Serializable {
    private Integer customerId;
    private Integer productId;

    // No-argument constructor
    public WishListId() {
    }

    // Constructors with both fields
    public WishListId(Integer customerId, Integer productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    // Getters and setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    // Implement equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishListId that = (WishListId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productId);
    }

}
