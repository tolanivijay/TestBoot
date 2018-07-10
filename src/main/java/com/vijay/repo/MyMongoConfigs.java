package com.vijay.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;

import com.mongodb.MongoClient;

@Configuration
public class MyMongoConfigs extends AbstractMongoConfiguration {
	
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private int port;


	@Override
	public MongoClient mongoClient() {
		return new MongoClient(host, port);
		
	}

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate myTemp = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
		myTemp.setWriteResultChecking(WriteResultChecking.EXCEPTION);
		return myTemp;
	}

}
