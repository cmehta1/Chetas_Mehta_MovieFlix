package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Movie;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.IMovieRepository;

@Service("movService")
@Transactional
public class MovieService implements IMovieService {

	@Autowired
	private IMovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie mov = repository.findOne(id);
		if(mov == null) {
			throw new EntityNotFoundException("Movie with id " + id + " doesn't exist");
		}
		return mov;
	}

	@Override
	public Movie create(Movie mov) {
		return repository.create(mov);
	}

	@Override
	public Movie update(String id, Movie mov) {
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie with id " + id + " doesn't exist");
		}
		return repository.update(mov);
	}

	@Override
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie with id " + id + " doesn't exist");
		}
		repository.delete(existing);
	}

}
