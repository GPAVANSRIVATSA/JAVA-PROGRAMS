package com.API.MovieCatlogService.Resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.API.MovieCatlogService.Models.CatalogItem;
import com.API.MovieCatlogService.Models.Movie;
import com.API.MovieCatlogService.Models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource {
	
	@Autowired
	public RestTemplate theRestTemplate;
	@Autowired
	public WebClient.Builder theWebClientBuilder;
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{
		List<Rating>ratings=Arrays.asList(
				new Rating("1234",3),
				new Rating("2345",4)
				);
		return ratings.stream().map(rating->{
			Movie theMovie=theRestTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Movie.class);
			/*Movie theMovie=theWebClientBuilder.build().get().uri("http://localhost:8082/movies/"+rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();*/
			return new CatalogItem(theMovie.getName(),"Test",rating.getRating());
		}).collect(Collectors.toList());
	}

}
