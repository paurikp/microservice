package io.javabrains.movieinfoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

//	public List<Movie> getAllMovies(String movieId) {
//		List<Movie> courses = new ArrayList<>();
//		movieRepository.findByMovieId(movieId).forEach(courses::add);
//		return courses;
//	}

	public Optional<Movie> getMovie(String id) {
		return movieRepository.findById(id);
	}

	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public void deleteMovie(String id) {
		movieRepository.deleteById(id);
	}

}
