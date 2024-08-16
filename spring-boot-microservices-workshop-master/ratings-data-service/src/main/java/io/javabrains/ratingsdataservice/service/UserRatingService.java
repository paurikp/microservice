package io.javabrains.ratingsdataservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.ratingsdataservice.model.UserRating;
import io.javabrains.ratingsdataservice.repository.UserRatingRepository;

@Service
public class UserRatingService {

	@Autowired
	private UserRatingRepository userRatingRepository;

//	public List<Movie> getAllMovies(String movieId) {
//		List<Movie> courses = new ArrayList<>();
//		movieRepository.findByMovieId(movieId).forEach(courses::add);
//		return courses;
//	}

	public UserRating getUserRating(String userId) {
		return userRatingRepository.findAllByUserId(userId);
	}

	public void addUserRating(UserRating rating) {
		userRatingRepository.save(rating);
	}

	public void updateUserRating(UserRating rating) {
		userRatingRepository.save(rating);
	}

	public void deleteUserRating(String id) {
		userRatingRepository.deleteById(id);
	}

}
