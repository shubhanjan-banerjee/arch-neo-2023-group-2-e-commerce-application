package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT_TYPES")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private int paymentTypeId;

    @Column(name = "payment_type_name")
    private String paymentTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public PaymentType() {
    }

    // Parameterized constructor
    public PaymentType(String paymentTypeName, String description, boolean isActive, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.paymentTypeName = paymentTypeName;
        this.description = description;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // Getters and setters
    // ...

    // Other methods
    // ...
}
