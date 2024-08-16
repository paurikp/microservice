package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;
import io.javabrains.ratingsdataservice.service.RatingService;
import io.javabrains.ratingsdataservice.service.UserRatingService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@Autowired
	private RatingService ratingService;

	@Autowired
	private UserRatingService userRatingService;

	@RequestMapping("/movies/{movieId}")
	public Optional<Rating> getMovieRating(@PathVariable("movieId") String movieId) {
		return ratingService.getRating(movieId);
//		return new Rating(movieId, 4);
	}

	@RequestMapping("/user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
//		UserRating userRating = new UserRating();
//		userRating.setRatings(null);
//		userRating.initData(userId);

		return userRatingService.getUserRating(userId);

	}

}
