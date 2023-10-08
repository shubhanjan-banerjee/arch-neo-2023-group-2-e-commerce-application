package com.archneo.ecommerce.repository;

import com.archneo.ecommerce.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Custom query to find customers by their full name
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    // Custom query to find customers by their email address
    Customer findByEmailId(String email);

    // Add more custom query methods as needed based on your requirements
}
