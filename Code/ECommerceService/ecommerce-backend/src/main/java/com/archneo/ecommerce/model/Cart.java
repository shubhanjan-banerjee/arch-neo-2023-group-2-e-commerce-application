package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Column(name = "status")
    private String status;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Constructors, getters, setters, and other methods

    // You can also add any additional fields, methods, and relationships here
}
