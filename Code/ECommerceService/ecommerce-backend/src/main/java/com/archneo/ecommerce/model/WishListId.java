package com.archneo.ecommerce.model;

import java.io.Serializable;
import java.util.Objects;

public class WishListId implements Serializable {
    private Integer customerId;
    private Integer productId;

    public WishListId(Integer customerId, Integer productId) {
        this.customerId = customerId;
        this.productId = productId;
    }
}
