package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "ORDERS")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnore
    private Timestamp createdAt;

    @Column(name = "modified_at")
    @JsonIgnore
    private Timestamp modifiedAt;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(CustomerAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public CustomerAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(CustomerAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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

	public Order() {
		super();
	}

	public Order(int orderId, Customer customer, Timestamp orderDate, BigDecimal totalAmount,
			CustomerAddress shippingAddress, CustomerAddress billingAddress, boolean isPaid, Payment payment,
			Delivery delivery, BigDecimal total, Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.isPaid = isPaid;
		this.payment = payment;
		this.delivery = delivery;
		this.total = total;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

    
}
