package com.yash.mba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yash.mba.domain.Seat;
import com.yash.mba.exception.MovieNotFoundException;
import com.yash.mba.repository.SeatRepository;
import com.yash.mba.service.SeatService;
@Service
@Primary
public class SeatServiceImpl implements SeatService {
	  private SeatRepository seatRepository;

	    @Autowired
	    public SeatServiceImpl(SeatRepository seatRepository) {
	        this.seatRepository = seatRepository;
	    }

	@Override
	public List<Seat> getAllSeats() {
		// TODO Auto-generated method stub
		return seatRepository.findAll();
	}

	@Override
	public Seat getSeatById(Long seat_id) {
		// TODO Auto-generated method stub
		return seatRepository.findById(seat_id).orElseThrow(() -> new MovieNotFoundException(seat_id));
	}

	@Override
	public Seat pushSeat(Seat newSeat) {
		// TODO Auto-generated method stub
		return seatRepository.save(newSeat);
	}

	@Override
	public Seat updateSeat(Seat updatedSeat, Long seat_id) {
		// TODO Auto-generated method stub
		seatRepository.findById(seat_id);
		updatedSeat.setId(seat_id);
		return seatRepository.save(updatedSeat);
	}

	@Override
	public void deleteSeatById(Long seat_id) {
		// TODO Auto-generated method stub
		 seatRepository.deleteById(seat_id);
		
	}

}
