package io.javabrains.moviecatalogservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.moviecatalogservice.models.CatalogItem;

public interface CatalogRepository extends CrudRepository<CatalogItem, String> {

	Optional<CatalogItem> findByName(String name);

}
