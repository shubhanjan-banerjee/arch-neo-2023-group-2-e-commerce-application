package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "INVOICES")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int invoiceId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "is_paid")
    private boolean paid;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "created_at")
    @JsonIgnore
    private Date createdAt;

    @Column(name = "modified_at")
    @JsonIgnore
    private Date modifiedAt;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Invoice() {
		super();
	}

	public Invoice(int invoiceId, Customer customer, Date invoiceDate, Date dueDate, BigDecimal totalAmount,
			boolean paid, Date paymentDate, Date createdAt, Date modifiedAt) {
		super();
		this.invoiceId = invoiceId;
		this.customer = customer;
		this.invoiceDate = invoiceDate;
		this.dueDate = dueDate;
		this.totalAmount = totalAmount;
		this.paid = paid;
		this.paymentDate = paymentDate;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

    
}

