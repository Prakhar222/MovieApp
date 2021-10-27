package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.AdminRepository;
import com.yash.mba.service.AdminService;
import com.yash.mba.web.AdminController;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminController adminController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(adminRepository);
		assertNotNull(adminController);
		assertNotNull(adminService);
	}
}
