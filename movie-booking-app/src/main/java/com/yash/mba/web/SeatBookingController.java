package com.yash.mba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.SeatBooking;
import com.yash.mba.service.SeatBookingService;

@RestController
@CrossOrigin
@RequestMapping("/seatbooking")

public class SeatBookingController {
    private SeatBookingService seatBookingService;

    @Autowired
    public SeatBookingController(SeatBookingService seatBookingService) {
        this.seatBookingService = seatBookingService;
    }

    @GetMapping("/seatbookings")
    public List<SeatBooking> getAllSeatBooked() {
        return seatBookingService.getAllSeatBooking();
    }
    @DeleteMapping("/{seat_booking_id}")
	public ResponseEntity<?> deleteSeatbookingById(@PathVariable Long seat_booking_id) {
		seatBookingService.deleteSeatBookingById(seat_booking_id);
		return ResponseEntity.noContent().build();
	}
    @GetMapping("/{seat_booking_id}")
	public ResponseEntity<?> getMovieById(@PathVariable Long seat_booking_id) {
		SeatBooking seatBooking = seatBookingService.getSeatBookingById(seat_booking_id);
		return ResponseEntity.status(HttpStatus.OK).body(seatBooking);
	}
    @PostMapping("/save")
   // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Movie>pushMovie (@RequestBody SeatBooking seatBooking)
	{    	
		seatBookingService.pushSeatBooking(seatBooking);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}  
}
