package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yash.mba.repository.AuditoriumRepository;
import com.yash.mba.service.AuditoriumService;
import com.yash.mba.web.AuditoriumController;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditoriumDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	AuditoriumRepository auditoriumRepository;
	
	@Autowired
	AuditoriumService auditoriumService;
	
	@Autowired
	AuditoriumController auditoriumController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(auditoriumRepository);
		assertNotNull(auditoriumController);
		assertNotNull(auditoriumService);
	}
}
