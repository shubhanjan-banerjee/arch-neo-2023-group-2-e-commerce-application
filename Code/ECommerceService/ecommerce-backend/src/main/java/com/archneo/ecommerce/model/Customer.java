package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @JsonIgnore
    @OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
    private Set<Authority> authorities;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getPreferredPaymentTypeId() {
		return preferredPaymentTypeId;
	}

	public void setPreferredPaymentTypeId(Integer preferredPaymentTypeId) {
		this.preferredPaymentTypeId = preferredPaymentTypeId;
	}

	public Integer getPreferredPaymentAddressId() {
		return preferredPaymentAddressId;
	}

	public void setPreferredPaymentAddressId(Integer preferredPaymentAddressId) {
		this.preferredPaymentAddressId = preferredPaymentAddressId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String username, String password, String firstName, String lastName,
			String emailId, String contactNumber, Integer preferredPaymentTypeId, Integer preferredPaymentAddressId,
			Set<Authority> authorities, Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.preferredPaymentTypeId = preferredPaymentTypeId;
		this.preferredPaymentAddressId = preferredPaymentAddressId;
		this.authorities = authorities;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

}
