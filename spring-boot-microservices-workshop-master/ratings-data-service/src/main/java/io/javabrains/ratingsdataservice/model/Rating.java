package io.javabrains.ratingsdataservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	private String movieId;

	private int rating;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserRating userRating;

	public Rating() {
	}

	public Rating(String movieId, int rating) {
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
