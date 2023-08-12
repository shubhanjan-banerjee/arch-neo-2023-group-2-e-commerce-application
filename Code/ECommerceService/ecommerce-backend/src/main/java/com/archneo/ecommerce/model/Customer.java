package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", unique = true)
    private String emailId;

    @Column(name = "contact_number", unique = true)
    private String contactNumber;

    @Column(name = "preferred_payment_type_id")
    private Integer preferredPaymentTypeId;

    @Column(name = "preferred_payment_address_id")
    private Integer preferredPaymentAddressId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Customer() {
    }

    // Getters and setters...

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Other getters and setters...
}
