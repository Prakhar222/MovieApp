package com.yash.mba.serviceTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.mba.MovieBookingAppApplication;
import com.yash.mba.domain.Admin;
import com.yash.mba.repository.AdminRepository;
import com.yash.mba.service.AdminService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class AdminServiceImplTest {
	@MockBean
	AdminRepository adminRepository;
	
	@Autowired
	AdminService adminService;
	
	@Test
	public void getAllTheatres()
	{
		Admin admin=new Admin();
		admin.setId(1L);
		admin.setAdminName("mack");
		admin.setAdminEmail("harsh@gmail.com");
		admin.setPassword("password99");
			//action
			Optional<Admin> p=Optional.of(new Admin());
			when(adminRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
}
