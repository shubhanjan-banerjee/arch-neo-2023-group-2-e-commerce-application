package com.archneo.ecommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "authority_id")
    private Long authority_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

	public Long getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(Long authority_id) {
		this.authority_id = authority_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Authority() {
		super();
	}

	public Authority(Long authority_id, String name, Customer customer) {
		super();
		this.authority_id = authority_id;
		this.name = name;
		this.customer = customer;
	}

}
