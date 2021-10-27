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
import com.yash.mba.domain.Screening;
import com.yash.mba.domain.Seat;
import com.yash.mba.service.ScreeningService;
import com.yash.mba.service.SeatService;

@RestController
@CrossOrigin
@RequestMapping("/seat")
public class SeatController {
    private SeatService seatService;
    private  ScreeningService screeningService;
    
    @Autowired
    public SeatController(SeatService seatService,ScreeningService screeningService) {
        this.seatService = seatService;
        this.screeningService=screeningService;
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
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}  
    
    @GetMapping("/seatbyauditoriumid/{auditorium_id}")
    public List<Seat> getSeatsByAuditoriumId(@PathVariable Long auditorium_id) {
      List<Seat> seats =seatService.getAllSeats();
      List<Seat> seats2 = seats.stream().filter(s -> s.getAuditorium().getId()==auditorium_id).toList();
    	return seats2;  
        }
   
    @GetMapping("/seatsbyscreeningid/{screening_id}")
    public List<Seat> getSeatsByScreeningId(@PathVariable Long screening_id) {
    	Screening screening= screeningService.getScreeningById(screening_id);
    	List<Seat> seats=seatService.getAllSeats();
    	List<Seat> seats2=seats.stream().filter(s->s.getAuditorium().getId()==screening.getAuditorium().getId()).toList();
    	
		return seats2;
    
    }
    
    
    
}
