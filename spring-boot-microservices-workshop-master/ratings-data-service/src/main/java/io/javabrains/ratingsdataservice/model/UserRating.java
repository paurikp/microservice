package io.javabrains.ratingsdataservice.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserRating {

	@Id
	private String userId;

	@OneToMany
	private List<Rating> ratings;

	public UserRating() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

//	public void initData(String userId) {
//		this.setUserId(userId);
//		this.setRatings(Arrays.asList(new Rating("100", 3), new Rating("200", 4)));
//	}
}
