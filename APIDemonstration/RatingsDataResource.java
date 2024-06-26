package com.API.RatingsDataService.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.RatingsDataService.Models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId)
	{
		return new Rating(movieId,4);
	}

}
