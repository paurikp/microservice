package io.javabrains.moviecatalogservice.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	WebClient.Builder webClientBuilder;

	@Autowired
	private CatalogService catalogService;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId,
				UserRating.class);

		return userRating.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					Movie.class);

			Optional<CatalogItem> catalogItem = catalogService.getCatalogItem(movie.getName());
			if (catalogItem.isPresent() && catalogItem.get().getId() != null) {
				catalogService.updateCatalogItem(new CatalogItem(catalogItem.get().getId(), movie.getName(),
						movie.getDescription(), rating.getRating()));
			} else {
				catalogService
						.addCatalogItem(new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating()));
			}

			return new CatalogItem(catalogItem.get().getId(), movie.getName(), movie.getDescription(),
					rating.getRating());
		}).collect(Collectors.toList());

	}
}

/*
 * Alternative WebClient way Movie movie =
 * webClientBuilder.build().get().uri("http://localhost:8082/movies/"+
 * rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
 */