package com.archneo.ecommerce.model;

import jakarta.persistence.*;
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

    // Getter and Setter methods
    // Constructors
    // Other methods if needed
}

