package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Movie;

public interface IMovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie mov);

	public Movie update(String id, Movie mov);

	public void delete(String id);
}
