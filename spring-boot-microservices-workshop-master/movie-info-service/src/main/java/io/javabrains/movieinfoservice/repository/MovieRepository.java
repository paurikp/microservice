package io.javabrains.movieinfoservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.movieinfoservice.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {

	public List<Movie> findByMovieId(String movieId);

}
