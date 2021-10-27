package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yash.mba.repository.SeatBookingRepository;
import com.yash.mba.service.SeatBookingService;
import com.yash.mba.web.SeatBookingController;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SeatBookingDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	SeatBookingRepository seatbookingRepository;
	
	@Autowired
	SeatBookingService seatbookingService;
	
	@Autowired
	SeatBookingController seatbookingController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(seatbookingRepository);
		assertNotNull(seatbookingController);
		assertNotNull(seatbookingService);
	}
}
