package com.yash.mba.serviceImpl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.domain.Customer;
import com.yash.mba.exception.MovieNotFoundException;
import com.yash.mba.repository.CustomerRepository;
import com.yash.mba.service.CustomerService;
@Service
@Primary
public class CustomerServiceImpl implements CustomerService{

	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long customer_id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customer_id).orElseThrow(() -> new MovieNotFoundException(customer_id));
	}

	@Override
	public Customer pushCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		return customerRepository.save(newCustomer);
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomer, Long customer_id) {
		// TODO Auto-generated method stub
		customerRepository.findById(customer_id);
		updatedCustomer.setCustomer_id(customer_id);
		return customerRepository.save(updatedCustomer);
	}

	@Override
	public void deleteCustomerById(Long customer_id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(customer_id);
	}

}
