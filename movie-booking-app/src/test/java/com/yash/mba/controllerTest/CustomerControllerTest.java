package com.yash.mba.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.yash.mba.repository.CustomerRepository;
import com.yash.mba.web.CustomerController;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;

	@MockBean
	CustomerRepository customerRepository;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void pushCustomer() throws Exception
	{
		String customer = "{\r\n"+ "  \"customer_name\": \"pqr\"\r\n"+ " }";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/customer/save")
				.content(customer)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
