package com.yash.mba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.domain.SeatBooking;
import com.yash.mba.exception.MovieNotFoundException;

import com.yash.mba.repository.SeatBookingRepository;
import com.yash.mba.service.SeatBookingService;

@Service
@Primary
public class SeatBookingServiceImpl implements SeatBookingService{

	private SeatBookingRepository seatBookingRepository;
	
    @Autowired
    public SeatBookingServiceImpl(SeatBookingRepository seatBookingRepository) {
        this.seatBookingRepository = seatBookingRepository;
    }

	@Override
	public List<SeatBooking> getAllSeatBooking() {
		// TODO Auto-generated method stub
		return seatBookingRepository.findAll();
	}

	@Override
	public SeatBooking getSeatBookingById(Long seat_booking_id) {
		// TODO Auto-generated method stub
		return seatBookingRepository.findById(seat_booking_id).orElseThrow(() -> new MovieNotFoundException(seat_booking_id));
	}

	@Override
	public SeatBooking pushSeatBooking(SeatBooking newSeatBooking) {
		// TODO Auto-generated method stub
		return seatBookingRepository.save(newSeatBooking);
	}

	@Override
	public void deleteSeatBookingById(Long seat_booking_id) {
		// TODO Auto-generated method stub
		seatBookingRepository.deleteById(seat_booking_id);
		
	}

	
}
