package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.SeatRepository;
import com.yash.mba.service.SeatService;
import com.yash.mba.web.SeatController;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SeatDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	SeatService seatService;
	
	@Autowired
	SeatController seatController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(seatRepository);
		assertNotNull(seatController);
		assertNotNull(seatService);
	}
}
