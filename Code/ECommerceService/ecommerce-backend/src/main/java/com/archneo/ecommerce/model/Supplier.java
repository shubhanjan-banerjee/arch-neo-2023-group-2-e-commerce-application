package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "website")
    private String website;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @Column(name = "payment_terms")
    private String paymentTerms;

    @Column(name = "preferred_shipping_method")
    private String preferredShippingMethod;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "rating")
    private float rating;

    @Column(name = "supplier_type")
    private String supplierType;

    // Getters and setters

    // Constructors

    // Other methods if needed
}
