package com.yash.mba.serviceTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.yash.mba.MovieBookingAppApplication;
import com.yash.mba.domain.Customer;
import com.yash.mba.repository.CustomerRepository;
import com.yash.mba.serviceImpl.CustomerServiceImpl;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class CustomerServiceImplTest {

	@InjectMocks 
	CustomerServiceImpl customerserviceimpl;

	@MockBean
	//@Autowired
	CustomerRepository customerRepository;
	

	@Test
	public void getCustomerByIdTest()
	{
		Customer customer=new Customer();
		customer.setCustomer_id((long) 3);
		customer.setCustomer_name("sameer");
		customer.setEmail("baner@gmail.com");
		//action
		Optional<Customer> p=Optional.of(new Customer());
		when(customerRepository.findById(3L)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
	@Test
	public void getAllCustomers() {
		Customer customer=new Customer();
		customer.setCustomer_id((long) 3);
		customer.setCustomer_name("sameer");
		customer.setEmail("baner@gmail.com");
		//action
		Optional<Customer> p=Optional.of(new Customer());
		when(customerRepository.findById(3L)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}

}
