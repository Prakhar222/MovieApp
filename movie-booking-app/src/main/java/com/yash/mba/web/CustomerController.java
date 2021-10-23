package com.yash.mba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Customer;
import com.yash.mba.domain.Movie;
import com.yash.mba.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController 
{
	 private CustomerService customerService;
	 
	 @Autowired
	    public CustomerController(CustomerService customerService) {
	        this.customerService = customerService;
	    }
	 @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }
	 
	 @GetMapping("/{customer_id}")
		public ResponseEntity<?> getCustomerById(@PathVariable Long  customer_id) {
	    	Customer customer = customerService.getCustomerById(customer_id);
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		}
	 
	 @PostMapping("/save")

		public ResponseEntity<Customer>pushCustomer (@RequestBody Customer customer)
		{    	
			customerService.pushCustomer(customer);
			return ResponseEntity.noContent().build();

		}  
	 
	 @PutMapping("/update/{customer_id}")
		public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customer_id) {
			customerService.updateCustomer(customer, customer_id);
			return new ResponseEntity<>(customerService.getCustomerById(customer_id), HttpStatus.OK);
		}
	 
	 @DeleteMapping("/customer/{customer_id}")
		public ResponseEntity<?> deleteCustomerById(@PathVariable Long customer_id) {
			customerService.deleteCustomerById(customer_id);
			return ResponseEntity.noContent().build();
		}
	 
	 
	 
}
