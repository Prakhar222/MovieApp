package com.yash.mba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Seat;
import com.yash.mba.service.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/seat")
public class SeatController {
    private SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats")
    public List<Seat> getAllSeats() {
        return this.seatService.getAllSeats();
    }
    @GetMapping("/{seat_id}")
	public ResponseEntity<?> getSeatById(@PathVariable Long seat_id) {
		Seat seat = seatService.getSeatById(seat_id);
		return ResponseEntity.status(HttpStatus.OK).body(seat);
	}
    @PutMapping("/update/{seat_id}")
	public ResponseEntity<?> updateMovie(@RequestBody Seat seat, @PathVariable Long seat_id) {
		seatService.updateSeat(seat, seat_id);
		return new ResponseEntity<>(seatService.getSeatById(seat_id), HttpStatus.OK);
	}
    @PostMapping("/save")

	public ResponseEntity<Movie>pushSeat (@RequestBody Seat seat)
	{    	
		seatService.pushSeat(seat);
		return ResponseEntity.noContent().build();

	}  
    
}
