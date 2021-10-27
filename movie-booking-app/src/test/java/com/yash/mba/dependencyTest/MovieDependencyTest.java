package com.yash.mba.dependencyTest;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.mba.repository.MovieRepository;
import com.yash.mba.service.MovieService;
import com.yash.mba.web.MovieController;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDependencyTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieController movieController;
	
	@Test
	public void checkInjectedComponentAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(applicationContext);
		assertNotNull(movieRepository);
		assertNotNull(movieController);
		assertNotNull(movieService);
	}
}
