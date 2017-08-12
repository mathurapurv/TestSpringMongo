package com.apurv.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apurv.mongo.dao.MovieMongoDao;
import com.apurv.mongo.model.Movie;


@Component
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieMongoDao movieMongoDao;
	
	
	@Override
	public Movie findByMovieID(Long movieId) {
		return movieMongoDao.findByMovieID(movieId);
	}
	
	@Override
	public List<Movie> findAll() {
		return movieMongoDao.findAll(100);
	}
	
	@Override
	public Long createMovie(  Movie movie){
		Long movieId = 		System.currentTimeMillis();
		movie.setMovieId(movieId);
		movieMongoDao.save(movie);
		return movieId;
	}

}
