package com.archneo.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "location")
    private String location;

    @Column(name = "stock_in_date")
    private Timestamp stockInDate;

    @Column(name = "stock_out_date")
    private Timestamp stockOutDate;

    @Column(name = "stock_in_by")
    private int stockInBy;

    @Column(name = "stock_out_by")
    private int stockOutBy;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    @Column(name = "expiry_date")
    private Timestamp expiryDate;

    @Column(name = "batch_number")
    private int batchNumber;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "reserved_quantity")
    private int reservedQuantity;

    @Column(name = "damaged_quantity")
    private int damagedQuantity;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Timestamp stockInDate) {
		this.stockInDate = stockInDate;
	}

	public Timestamp getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Timestamp stockOutDate) {
		this.stockOutDate = stockOutDate;
	}

	public int getStockInBy() {
		return stockInBy;
	}

	public void setStockInBy(int stockInBy) {
		this.stockInBy = stockInBy;
	}

	public int getStockOutBy() {
		return stockOutBy;
	}

	public void setStockOutBy(int stockOutBy) {
		this.stockOutBy = stockOutBy;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getReservedQuantity() {
		return reservedQuantity;
	}

	public void setReservedQuantity(int reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public int getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(int damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Inventory() {
		super();
	}

	public Inventory(int inventoryId, Product product, int quantity, String location, Timestamp stockInDate,
			Timestamp stockOutDate, int stockInBy, int stockOutBy, BigDecimal unitCost, Timestamp expiryDate,
			int batchNumber, Supplier supplier, String remarks, int reservedQuantity, int damagedQuantity,
			boolean isActive, Timestamp createdAt, Timestamp modifiedAt) {
		super();
		this.inventoryId = inventoryId;
		this.product = product;
		this.quantity = quantity;
		this.location = location;
		this.stockInDate = stockInDate;
		this.stockOutDate = stockOutDate;
		this.stockInBy = stockInBy;
		this.stockOutBy = stockOutBy;
		this.unitCost = unitCost;
		this.expiryDate = expiryDate;
		this.batchNumber = batchNumber;
		this.supplier = supplier;
		this.remarks = remarks;
		this.reservedQuantity = reservedQuantity;
		this.damagedQuantity = damagedQuantity;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

    
}

