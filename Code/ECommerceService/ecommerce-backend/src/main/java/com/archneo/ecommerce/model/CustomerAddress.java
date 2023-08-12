package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER_ADDRESSES")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    // Constructors, getters, setters, and other methods

    // Define appropriate constructors, getters, setters, and other methods here
}

