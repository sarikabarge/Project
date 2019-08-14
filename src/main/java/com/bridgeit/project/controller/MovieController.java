package com.bridgeit.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgeit.project.dto.MovieDTO;
import com.bridgeit.project.model.Actor;
import com.bridgeit.project.model.Movie;
import com.bridgeit.project.response.Response;
import com.bridgeit.project.service.MovieService;
@RestController
@RequestMapping("/moviecontoller")

public class MovieController {
	
	@Autowired 
	private MovieService movieService;

	@PostMapping("/movieRegister")
	public ResponseEntity<Response> register(@RequestBody MovieDTO moviedto,@RequestParam long producerId,@RequestParam List<String> actors){
		System.out.println("in controller");
		Response response = movieService.createActorProducerToMovie(moviedto,producerId,actors);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	/*
	 * @PostMapping("/addActorProducerToMovie") public ResponseEntity<Response>
	 * addActorProducerToMovie(@RequestParam long movieId,@RequestParam long
	 * producerId,@RequestParam List<String> actors){
	 * System.out.println("in controller"); Response response =
	 * movieService.addActorProducerToMovie(movieId,producerId,actors);
	 * System.out.println(response); return new ResponseEntity<>(response,
	 * HttpStatus.OK);
	 * 
	 * }
	 */
	
	@PutMapping("/updatemovie")
	public ResponseEntity<Response> updatemovie(@RequestBody MovieDTO moviedto,@RequestParam long movieId){
		System.out.println("in controller");
		Response response = movieService.updateMovie(moviedto,movieId);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	@GetMapping("/getAllMovieWithActorAndProducer")
	public List<Movie> getMovie(@RequestParam long movieId) {
		List<Movie> listuser = movieService.getAllMovieWithActorAndProducer(movieId);
		System.out.println(listuser);
		return listuser;
	}
	
}
