package io.javabrains.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;
import io.javabrains.movieinfoservice.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MovieService movieService;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
		Movie movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
		movieService.addMovie(movie);
		return movie;
//        https://api.themoviedb.org/3/movie/157336?api_key=0e5d3d5f408ffc6680473043c5cc6434
	}
}
