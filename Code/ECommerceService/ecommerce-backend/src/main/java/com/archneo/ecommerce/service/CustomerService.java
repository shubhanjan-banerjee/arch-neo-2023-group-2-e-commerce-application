package com.archneo.ecommerce.service;

import com.archneo.ecommerce.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

public interface CustomerService {
    Page<Customer> getAllCustomers(MultiValueMap<String, String> params, Pageable pageable);
    Customer getCustomerById(int customerId);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(int customerId, Customer customer);
    void deleteCustomer(int customerId);
}
