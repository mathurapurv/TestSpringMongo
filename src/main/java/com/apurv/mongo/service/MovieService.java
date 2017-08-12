package com.apurv.mongo.service;

import java.util.List;

import com.apurv.mongo.model.Movie;

public interface MovieService {

	Movie findByMovieID(Long movieId);

	List<Movie> findAll();

	Long createMovie(Movie movie);

}
