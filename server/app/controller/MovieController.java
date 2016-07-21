package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Movie;
import io.egen.app.service.IMovieService;




@RestController
@CrossOrigin(origins="http://localhost:63342")
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	@Qualifier("movService")
	private IMovieService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Movie> findAll () {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Movie create (@RequestBody Movie mov) {
		return service.create(mov);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Movie update (@PathVariable("id") String movieId, @RequestBody Movie mov) {
		return service.update(movieId, mov);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete (@PathVariable("id") String movieId) {
		service.delete(movieId);
	}
}
