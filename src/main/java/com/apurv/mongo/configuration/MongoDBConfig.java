package com.apurv.mongo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;

import com.mongodb.MongoClientOptions;

@Configuration
public class MongoDBConfig {
	
	private static final String MONGO_HOST="localhost";

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate template = new MongoTemplate(mongoClientFactoryBean().getObject(), "imdb");
		template.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		return template;
	} 

	@Bean
	public MongoClientFactoryBean mongoClientFactoryBean() {
		MongoClientFactoryBean m = new MongoClientFactoryBean();
		m.setHost(MONGO_HOST);
		MongoClientOptions options = MongoClientOptions.builder()
				.connectionsPerHost(10)
				.threadsAllowedToBlockForConnectionMultiplier(10).build();
		m.setMongoClientOptions(options);
		return m;

	}
}
