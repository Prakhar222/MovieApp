/*package com.yash.mba.controllerTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.yash.mba.domain.Admin;
import com.yash.mba.repository.AdminRepository;
import com.yash.mba.web.AdminController;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
	@InjectMocks
	AdminController adminController;
	
	@MockBean
	AdminRepository adminRepository;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void whenGetRequestForAll_thenReturnAllAdmins() throws Exception {
		List<Admin> Admin = new ArrayList<>();
		when(adminRepository.findAll()).thenReturn(Admin);
		
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/admin/admins"))
		.andExpect(MockMvcResultMatchers.status().isFound());
	}
}*/
