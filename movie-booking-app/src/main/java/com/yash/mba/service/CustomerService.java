package com.yash.mba.service;

import java.util.List;

import com.yash.mba.domain.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long customer_id);

	Customer pushCustomer(Customer newCustomer);

	Customer updateCustomer(Customer updatedCustomer, Long customer_id);

    void deleteCustomerById(Long customer_id);
}
