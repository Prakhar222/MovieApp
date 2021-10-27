package com.yash.mba.web;

import java.io.Console;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.exception.HousefullException;
import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Screening;
import com.yash.mba.domain.Seat;
import com.yash.mba.domain.Theatre;
import com.yash.mba.service.ScreeningService;

@RestController
@CrossOrigin
@RequestMapping("/screening")
public class ScreeningController {
    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/screenings")
    public ResponseEntity<?> getAllScreenings(@RequestParam(required = false) Map<String, String> dates) {
        List<Screening> screenings = null;
        if(!dates.isEmpty()) {
            LocalDate startDate = LocalDate.parse(dates.get("startDate"));
            LocalDate endDate = LocalDate.parse(dates.get("endDate"));
            screenings = screeningService.getAllScreenings(startDate, endDate);
        } else {
            screenings = screeningService.getAllScreenings();
        }
        return ResponseEntity.status(HttpStatus.OK).body(screenings);
    }

    @GetMapping("/{screening_id}")
    public ResponseEntity<?> getScreenById(@PathVariable Long screening_id) {
        Screening screening = screeningService.getScreeningById(screening_id);
        return ResponseEntity.status(HttpStatus.OK).body(screening);
    }

//    @GetMapping("/screenings/{screening_id}/seats")
//    public ResponseEntity<?> getSeatsByScreeningId(@PathVariable Long screening_id) throws HousefullException {
//        List<Seat> seats = screeningService.getSeatsByScreeningId(screening_id);
//        if(seats.size() == 0) {
//           throw new HousefullException();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(seats);
//    }
    
    
    @PostMapping("/save")

	public ResponseEntity<Movie>pushScreening (@RequestBody Screening screening)
	{    	
		screeningService.pushScreening(screening);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	} 
    
    @PutMapping("/update/{screening_id}")
	public ResponseEntity<?> updateScreening(@RequestBody Screening screening, @PathVariable Long screening_id) {
		screeningService.updateScreening(screening, screening_id);
		return new ResponseEntity<>(screeningService.getScreeningById(screening_id), HttpStatus.OK);
	}
    
    @PostMapping("/showbymovieid/{movie_id}")
   // public ResponseEntity<?> screeningByMoveiId(@RequestBody Theatre theatre, @PathVariable Long movie_id) {
    public List<Screening> screeningByMoveiId(@RequestBody Theatre theatre, @PathVariable Long movie_id) {

    List<Screening> screenings=screeningService.getAllScreenings();
		List<Screening> screenings2=screenings.stream().filter(s -> s.getMovie().getId()==movie_id).toList();
	    List<Screening> screenings3=screenings2.stream().filter(s ->s.getAuditorium().getTheatre().getId()==theatre.getId()).toList();
		System.out.println("hello");
		return screenings3;
		 //return ResponseEntity.status(HttpStatus.OK).body(screenings3);
    	
    }
    @GetMapping("/screeningsbyid/{movie_id}")
    public List<Screening> getScreeningsById( @PathVariable Long movie_id) {
    	 List<Screening> screenings=screeningService.getAllScreenings();
 		List<Screening> screenings2=screenings.stream().filter(s -> s.getMovie().getId()==movie_id).toList();
		return screenings2;
    	
    }

	@DeleteMapping("/screenings/{screening_id}")
	public ResponseEntity<?> deleteScreeningById(@PathVariable Long screening_id) {
		screeningService.deleteScreening(screening_id);
		return ResponseEntity.noContent().build();
	}
    
}
