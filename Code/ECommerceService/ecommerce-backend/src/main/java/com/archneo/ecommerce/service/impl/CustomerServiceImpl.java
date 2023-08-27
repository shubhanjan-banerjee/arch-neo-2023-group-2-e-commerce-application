package com.archneo.ecommerce.service.impl;

import com.archneo.ecommerce.model.Customer;
import com.archneo.ecommerce.repository.CustomerRepository;
import com.archneo.ecommerce.service.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getAllCustomers(MultiValueMap<String, String> params, Pageable pageable) {
        // Implement your search, filter, and sorting logic using params here
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // Implement create logic here
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer) {
        // Implement update logic here
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
