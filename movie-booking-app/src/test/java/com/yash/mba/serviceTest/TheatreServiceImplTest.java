package com.yash.mba.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.yash.mba.domain.Theatre;
import com.yash.mba.repository.TheatreRepository;
import com.yash.mba.service.TheatreService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class TheatreServiceImplTest {
	@MockBean
	TheatreRepository theatreRepository;
	
	@Autowired
	TheatreService theatreService;
	
	@Test
	public void when_addTheatre_ItShouldReturn_Theatre() {
		
		Theatre p = new Theatre();
		when(theatreRepository.save(p)).thenReturn(p);
		
		assertThat(theatreService.pushTheatre(p)).isEqualTo(p);
	}
	@Test
	public void getAllTheatres()
	{
		Theatre theatre=new Theatre();
		theatre.setId(1L);
		theatre.setName("ganesh theatre");
			//action
			Optional<Theatre> p=Optional.of(new Theatre());
			when(theatreRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
}
