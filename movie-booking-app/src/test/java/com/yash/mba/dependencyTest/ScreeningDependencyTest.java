package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.ScreeningRepository;
import com.yash.mba.service.ScreeningService;
import com.yash.mba.web.ScreeningController;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ScreeningDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	ScreeningRepository screeningRepository;
	
	@Autowired
	ScreeningService screeningService;
	
	@Autowired
	ScreeningController screeningController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(screeningRepository);
		assertNotNull(screeningController);
		assertNotNull(screeningService);
	}
}
