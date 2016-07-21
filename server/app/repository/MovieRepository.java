package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Movie;

@Repository
public class MovieRepository implements IMovieRepository {

	@PersistenceContext
	private EntityManager mo;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = mo.createQuery("SELECT mov FROM Movie mov", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return mo.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie mov) {
		mo.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return mo.merge(mov);
	}

	@Override
	public void delete(Movie mov) {
		mo.remove(mov);
	}

}
