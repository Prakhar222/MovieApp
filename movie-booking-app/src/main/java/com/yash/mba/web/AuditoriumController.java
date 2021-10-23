package com.yash.mba.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Auditorium;
import com.yash.mba.domain.Movie;
import com.yash.mba.service.AuditoriumService;

@CrossOrigin
@RestController
@RequestMapping("/auditorium")
public class AuditoriumController {
	 private AuditoriumService auditoriumService;

	    @Autowired
	    public AuditoriumController(AuditoriumService auditoriumService) {
	        this.auditoriumService = auditoriumService;
	    }

	    @GetMapping("/auditoriums")
	    public List<Auditorium> getAllTheatres() {
	        return auditoriumService.getAllAuditoriums();
	    }
	    
	    @PostMapping("/save")
		public ResponseEntity<Auditorium>pushAuditorium (@RequestBody Auditorium auditorium)
		{    	
	    	auditoriumService.pushAuditorium(auditorium);
			return ResponseEntity.noContent().build();

		}  

	    
}
