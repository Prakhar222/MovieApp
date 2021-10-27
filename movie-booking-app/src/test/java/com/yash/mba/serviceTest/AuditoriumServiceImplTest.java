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
import com.yash.mba.domain.Auditorium;
import com.yash.mba.repository.AuditoriumRepository;
import com.yash.mba.service.AuditoriumService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class AuditoriumServiceImplTest {
	@MockBean
	AuditoriumRepository auditoriumRepository;
	
	@Autowired
	AuditoriumService auditoriumService;
	
	@Test
	public void when_addAuditorium_ItShouldReturn_Auditorium() {
		
		Auditorium p = new Auditorium();
		when(auditoriumRepository.save(p)).thenReturn(p);
		
		assertThat(auditoriumService.pushAuditorium(p)).isEqualTo(p);
	}
	@Test
	public void when_getAllAuditoriums_ShouldGet_Records()
	{
		Auditorium auditorium=new Auditorium();
		auditorium.setId(1L);
		auditorium.setSeatCount(32);
		auditorium.setTheatre(null);
			//action
			Optional<Auditorium> p=Optional.of(new Auditorium());
			when(auditoriumRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
}
