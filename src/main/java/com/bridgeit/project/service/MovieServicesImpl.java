package com.bridgeit.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgeit.project.dto.MovieDTO;
import com.bridgeit.project.model.Actor;
import com.bridgeit.project.model.Movie;
import com.bridgeit.project.model.Producer;
import com.bridgeit.project.repository.ActorRepository;
import com.bridgeit.project.repository.MovieRepository;
import com.bridgeit.project.repository.ProducerRepository;
import com.bridgeit.project.response.Response;
import com.bridgeit.project.exception.UserException;

@Service
public class MovieServicesImpl implements MovieService {

	// @Autowired
	// private ModelMapper modelMapper;
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private ProducerRepository producerRepository;

	@Override
	public Response createActorProducerToMovie(MovieDTO moviedto,long producerId, List<String> actors) {
		ModelMapper modelMapper = new ModelMapper();
		Movie movie = modelMapper.map(moviedto, Movie.class);
		List<Actor> newActors =new ArrayList<Actor>();
		for (String actor1 : actors) {
			Optional<Actor> actor =actorRepository.findByName(actor1);
			System.out.println("create movie"+actor1);
			
			if (!actor.isPresent()) {
				return new Response("actor not found ", 404);
			}
			newActors.add(actor.get());
			
           System.out.println("create movie"+actor.get());
         
           //movie.getActors().add(actor.get());
           //movie.setActors(newActors);
			movieRepository.save(movie);

			actor.get().getMovies().add(movie);
			actorRepository.save(actor.get());
		}

		Optional<Producer> producer = producerRepository.findById(producerId);

		if (!producer.isPresent()) {
			// logger.info("in email");
			return new Response("producer not found ", 404);
		}
		movie.setProducerId(producerId);
		movieRepository.save(movie);
		producer.get().getMovies().add(movie);
		producerRepository.save(producer.get());
		Response response = ResponseHelper.statusResponse(100, "actor added to movie");
		return response;
	}
	
	@Override
	public Response updateMovie(MovieDTO moviedto,long movieId)
	{
		Movie movie=movieRepository.findById(movieId).orElseThrow(() -> new UserException("No movie is available"));
		movie.setMovieName(moviedto.getMovieName());
		movie.setPlot(moviedto.getPlot());
		movie.setPoster(moviedto.getPoster());
		movie.setYear(moviedto.getYearOfRelease());
		movieRepository.save(movie);
		Response response = ResponseHelper.statusResponse(100, "update movie");
		return response;
	}	
	@Override
	public List<Movie> getAllMovieWithActorAndProducer(long movieId) {
		List<Movie> movielist = movieRepository.findAll();
		System.out.println("movielist"+movielist.size());
		
		return movielist;
	}

}
