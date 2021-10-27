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
import com.yash.mba.domain.SeatBooking;
import com.yash.mba.domain.Theatre;
import com.yash.mba.repository.SeatBookingRepository;
import com.yash.mba.service.SeatBookingService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {MovieBookingAppApplication.class})
public class SeatBookingServiceImplTest {
	@MockBean
	SeatBookingRepository seatbookingRepository;
	
	@Autowired
	SeatBookingService seatbookingService;
	
	@Test
	public void when_addseatbooking_ItShouldReturn_seatbooking() {
		
		SeatBooking p = new SeatBooking();
		when(seatbookingRepository.save(p)).thenReturn(p);
		
		assertThat(seatbookingService.pushSeatBooking(p)).isEqualTo(p);
	}
	@Test
	public void getAllSeatBooking()
	{
		SeatBooking seatbooking=new SeatBooking();
		seatbooking.setId(1L);
		seatbooking.setSeat(null);
		seatbooking.setScreening(null);
			//action
			Optional<SeatBooking> p=Optional.of(new SeatBooking());
			when(seatbookingRepository.findById(1L)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
	}
}
