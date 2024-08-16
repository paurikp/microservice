package io.javabrains.ratingsdataservice.repository;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.ratingsdataservice.model.UserRating;

public interface UserRatingRepository extends CrudRepository<UserRating, String> {

	UserRating findAllByUserId(String userId);

}
