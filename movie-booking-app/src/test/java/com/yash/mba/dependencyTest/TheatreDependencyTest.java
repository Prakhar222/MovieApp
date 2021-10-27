package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.TheatreRepository;
import com.yash.mba.service.TheatreService;
import com.yash.mba.web.TheatreController;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TheatreDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	TheatreService theatreService;
	
	@Autowired
	TheatreController theatreController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(theatreRepository);
		assertNotNull(theatreController);
		assertNotNull(theatreService);
	}
}
