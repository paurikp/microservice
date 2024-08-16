package io.javabrains.ratingsdataservice.repository;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.ratingsdataservice.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, String> {

}
