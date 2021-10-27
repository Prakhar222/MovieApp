package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.UserRepository;

import com.yash.mba.service.UserService;
import com.yash.mba.web.UserController;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserController userController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(userRepository);
		assertNotNull(userController);
		assertNotNull(userService);
	}
}
