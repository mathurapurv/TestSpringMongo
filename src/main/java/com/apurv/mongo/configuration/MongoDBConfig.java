package com.apurv.mongo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientOptions;

@Configuration
public class MongoDBConfig {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClientFactoryBean().getObject(), "imdb");
	} 

	@Bean
	public MongoClientFactoryBean mongoClientFactoryBean() {
		MongoClientFactoryBean m = new MongoClientFactoryBean();
		m.setHost("localhost");
		MongoClientOptions options = MongoClientOptions.builder()
				.connectionsPerHost(10)
				.threadsAllowedToBlockForConnectionMultiplier(10).build();
		m.setMongoClientOptions(options);
		return m;

	}
}
