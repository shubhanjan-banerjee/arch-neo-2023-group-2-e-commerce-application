package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id", nullable = false)
    private CustomerAddress shippingAddress;

    @ManyToOne
    @JoinColumn(name = "billing_address", nullable = false)
    private CustomerAddress billingAddress;

    @Column(name = "is_paid")
    private boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "payment_id", unique = true, nullable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "delivery_id", unique = true, nullable = false)
    private Delivery delivery;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Constructors, getters, setters, and other methods...
}
