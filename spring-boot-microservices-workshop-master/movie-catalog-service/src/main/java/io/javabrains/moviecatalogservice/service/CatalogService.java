package io.javabrains.moviecatalogservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.repository.CatalogRepository;

@Service
public class CatalogService {

	@Autowired
	private CatalogRepository catalogRepository;

//	public List<Movie> getAllMovies(String movieId) {
//		List<Movie> courses = new ArrayList<>();
//		movieRepository.findByMovieId(movieId).forEach(courses::add);
//		return courses;
//	}

	public Optional<CatalogItem> getCatalogItem(String name) {
		return catalogRepository.findByName(name);
	}

	public void addCatalogItem(CatalogItem catalogItem) {
		catalogRepository.save(catalogItem);
	}

	public void updateCatalogItem(CatalogItem catalogItem) {
		catalogRepository.save(catalogItem);
	}

	public void deleteCatalogItem(String id) {
		catalogRepository.deleteById(id);
	}

}
