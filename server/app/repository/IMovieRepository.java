package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Movie;

public interface IMovieRepository {

	public List<Movie> findAll();
	
	public Movie findOne(String id);
	
	public Movie create (Movie mov);
	
	public Movie update (Movie mov);
	
	public void delete (Movie mov);
}
