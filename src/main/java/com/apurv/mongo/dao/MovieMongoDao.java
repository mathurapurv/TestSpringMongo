package com.apurv.mongo.dao;

import java.util.List;

import com.apurv.mongo.model.Movie;

public interface MovieMongoDao {

	Movie findByMovieID(Long movieId);
	List<Movie> findAll(int maxResultSize);
	void save(Movie movie);
	int delete(Long movieId);

}
