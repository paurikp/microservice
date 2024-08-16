package io.javabrains.ratingsdataservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;

//	public List<Movie> getAllMovies(String movieId) {
//		List<Movie> courses = new ArrayList<>();
//		movieRepository.findByMovieId(movieId).forEach(courses::add);
//		return courses;
//	}

	public Optional<Rating> getRating(String movieId) {
		return ratingRepository.findById(movieId);
	}

	public void addRating(Rating rating) {
		ratingRepository.save(rating);
	}

	public void updateRating(Rating rating) {
		ratingRepository.save(rating);
	}

	public void deleteRating(String id) {
		ratingRepository.deleteById(id);
	}

}
