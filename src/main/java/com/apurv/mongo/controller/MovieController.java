package com.apurv.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apurv.mongo.model.Movie;
import com.apurv.mongo.service.MovieService;

@RestController
@RequestMapping(value = "/imdb")
public class MovieController {
 
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String index() {
		System.out.println("index() is executed!");
		return "Hello world ";
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
	@ResponseBody
	public Movie getMovieByMovieID(@PathVariable("movieId") Long movieId) {
		return movieService.findByMovieID(movieId);
	}
	
	@RequestMapping(value = "/movie/dump", method = RequestMethod.GET)
	@ResponseBody
	public List<Movie> getMovieByMovieID() {
		return movieService.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/createMovie",consumes="application/json")
	public Long createMovie(@RequestBody Movie movie) {
		System.out.println(movie);
		return movieService.createMovie(movie);
	}
}
