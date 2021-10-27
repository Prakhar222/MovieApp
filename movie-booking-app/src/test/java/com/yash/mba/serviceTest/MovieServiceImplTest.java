package com.yash.mba.serviceTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.mba.MovieBookingAppApplication;
import com.yash.mba.domain.Movie;
import com.yash.mba.repository.MovieRepository;
import com.yash.mba.serviceImpl.MovieServiceImpl;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class MovieServiceImplTest {
	@MockBean
	MovieRepository movieRepository;
	
	@InjectMocks 
	MovieServiceImpl movieserviceimpl;

	@Test
	public void getAllMovies()
	{
			Movie movie=new Movie();
			movie.setId(1L);
			movie.setPoster("poster1");
			movie.setTitle("title1");
			movie.setGenre("abc");
			movie.setDuration(12);
			//action
			Optional<Movie> p=Optional.of(new Movie());
			when(movieRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
}