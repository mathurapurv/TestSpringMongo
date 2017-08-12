package com.apurv.mongo;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.apurv.mongo.model.Movie;
import com.apurv.mongo.util.RandomGenerationUtils;

public class MainRunner {

	private static final MainRunner instance = new MainRunner();

	private static final String COLLECTION_NAME_MOVIE = "movies";
	private AbstractApplicationContext ctx = null;

	private MainRunner() {
	}

	public static void main(String[] args) {
		System.out.println("Start");
		instance.initializeContext();
		
		// [Start] call your methods here 
		
		
		
		instance.createMovie();
		
		
		
		
		
		
		
		
		
		
		
		
		
		// [End] call your methods here
		instance.closeContext();
		System.out.println("End");

	}
	
	
	private void createMovie(){
		
		
		
		Long movieId = RandomGenerationUtils.randomLong(4);
		
		Movie m = new Movie();
		m.setMovieId(movieId);;
		m.setMovieName("testmovie123");
		m.setLanguage("Hindi");
		m.setNetflixAvailable(true);
		m.setDescription("random bunch");
		m.setReleaseDate(new Date());
		
		MongoTemplate template = ctx.getBean(MongoTemplate.class);
		
		dropCollection(COLLECTION_NAME_MOVIE);
		
		template.save(m);
		
		
		print("MOvies in collection : "+template.count((new Query()), COLLECTION_NAME_MOVIE));
		
		
		
		
	}
	
	
	
	
	
	
	private void dropCollection(String collectionName){
		MongoTemplate template = ctx.getBean(MongoTemplate.class);
		template.dropCollection(collectionName);
	}
	
	
	
	
	
	
	
	
	

	private void initializeContext() {
		ctx = new AnnotationConfigApplicationContext("com.apurv.mongo");
		for (String beanName : ctx.getBeanDefinitionNames())
			print("Bean : " + beanName);
		
		print("-- Context initialized---");

	}

	private void closeContext() {
		if ((ctx != null) && (ctx.isActive())) {
			ctx.close();
		}
	}
	
	private void  print(Object obj){
		System.out.println(">> "+ String.valueOf(obj));
	}
	
	
}
