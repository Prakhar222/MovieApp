package com.yash.mba.domain;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long customer_id;

	private String customer_name;
	
	private String email;
	

	@OneToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	





	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param customer_id
	 * @param customer_name
	 
	 * @param email
	 */
	public Customer(Long customer_id, String customer_name,  String email) {
		super();
		this.customer_id = customer_id;
		
		this.customer_name = customer_name;
		
		this.email = email;
	}


	/**
	 * @return the customer_id
	 */
	public Long getCustomer_id() {
		return customer_id;
	}
	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + 
				", email=" + email + ", user=" + user + "]";
	}
	
	
	
	
	
	
}