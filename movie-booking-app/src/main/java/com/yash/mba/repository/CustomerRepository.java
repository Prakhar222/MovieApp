package com.yash.mba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.mba.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
