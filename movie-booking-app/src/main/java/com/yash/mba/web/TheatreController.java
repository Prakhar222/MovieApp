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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Theatre;
import com.yash.mba.service.TheatreService;

@RestController
@CrossOrigin
@RequestMapping("/theatre")
public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }
    @GetMapping("/{theatre_id}")
	public ResponseEntity<?> getTheatreById(@PathVariable Long  theatre_id) {
    	Theatre theatre = theatreService.getTheatreById(theatre_id);
		return ResponseEntity.status(HttpStatus.OK).body(theatre);
	}
    @PostMapping("/save")

	public ResponseEntity<Theatre>pushTheatre (@RequestBody Theatre theatre)
	{    	
    	theatreService.pushTheatre(theatre);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	} 
    
    @PutMapping("/update/{theatre_id}")
	public ResponseEntity<?> updateTheatre(@RequestBody Theatre theatre, @PathVariable Long theatre_id) {
    	theatreService.updateTheatre(theatre, theatre_id);
		return new ResponseEntity<>(theatreService.getTheatreById(theatre_id), HttpStatus.OK);
	}
    
    @DeleteMapping("/delete/{theatre_id}")
	public ResponseEntity<?> deleteTheatreById(@PathVariable Long theatre_id) {
		theatreService.deleteTheatreById(theatre_id);
		return ResponseEntity.noContent().build();
	}

   
}
