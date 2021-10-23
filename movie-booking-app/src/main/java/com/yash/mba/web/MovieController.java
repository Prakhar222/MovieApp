package com.yash.mba.web;

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

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.Screening;
import com.yash.mba.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {
	private MovieService movieService;


	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/movies")
	public ResponseEntity<?> getAllMovies(@RequestParam Map<String, String> dates) {
		List<Movie> movies = movieService.getAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(movies);
	}

	@GetMapping("/movies/{movie_id}")
	public ResponseEntity<?> getMovieById(@PathVariable Long movie_id) {
		Movie movie = movieService.getMovieById(movie_id);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
//
//	@GetMapping("/movies/{movie_id}/screenings")
//	public ResponseEntity<?> getAllScreeningByMovieId(@PathVariable Long movie_id) {
//		List<Screening> screenings = movieService.getAllScreeningByMovieId(movie_id);
//		return ResponseEntity.status(HttpStatus.OK).body(screenings);
//	}

	@DeleteMapping("/movies/{movie_id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Long movie_id) {
		movieService.deleteMovie(movie_id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update/{movie_id}")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable Long movie_id) {
		movieService.updateMovie(movie, movie_id);
		return new ResponseEntity<>(movieService.getMovieById(movie_id), HttpStatus.OK);
	}

	@PostMapping("/save")

	public ResponseEntity<Movie>pushMovie (@RequestBody Movie movie)
	{    	
		movieService.saveMovie(movie);
		return ResponseEntity.noContent().build();

	}  
}