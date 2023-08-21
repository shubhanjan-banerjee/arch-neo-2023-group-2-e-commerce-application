package com.archneo.ecommerce.controller;

import com.archneo.ecommerce.model.Customer;
import com.archneo.ecommerce.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Page<Customer> getAllCustomers(@RequestParam MultiValueMap<String, String> params) {
        int pageNumber = params.containsKey("page") ? Integer.parseInt(params.getFirst("page")) : 0;
        int pageSize = params.containsKey("size") ? Integer.parseInt(params.getFirst("size")) : 10;
        String sortField = params.containsKey("sort") ? params.getFirst("sort") : "customerId";
        Sort.Direction sortDirection = params.containsKey("order") && params.getFirst("order").equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField));

        return customerService.getAllCustomers(params, pageable);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
