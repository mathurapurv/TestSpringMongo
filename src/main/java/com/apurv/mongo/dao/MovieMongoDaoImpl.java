package com.apurv.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.apurv.mongo.model.Movie;

@Component
public class MovieMongoDaoImpl implements MovieMongoDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Movie findByMovieID(Long movieId) {
		Movie m = mongoTemplate.findOne(createQuery(Criteria.where("movie_id").is(movieId)), Movie.class);
		return m;
	}
	
	@Override
	public List<Movie> findAll(int maxResultSize) {
		return mongoTemplate.find((new Query()).limit(maxResultSize), Movie.class);
	}

	@Override
	public void save(Movie movie) {
		mongoTemplate.save(movie);
	}
	
	
	private Query createQuery(Criteria c) {
		Query q = new Query();
		q.addCriteria(c);
		return q;
	}

}
