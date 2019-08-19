package com.java.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@ComponentScan(basePackages="com.java")
@EnableMongoRepositories(basePackages="com.java.dao")
public class SpringConfig {

	
	@Bean 
	public MongoClient client() {
		MongoCredential credenciales=MongoCredential.createCredential("Guru99", "admin", "password".toCharArray());
		MongoClient client = new MongoClient(new ServerAddress("35.154.224.124"), Arrays.asList(credenciales));
		return client;
	}
	
	@Bean
	public MongoDbFactory factory() {
		MongoDbFactory factory= new SimpleMongoDbFactory(client() , "shoppingApp");
		
		return factory;
		
	}
	@Bean("mongoTemplate")
	public MongoTemplate template() {
		MongoTemplate template= new MongoTemplate(factory());
		//template.setWriteConcern(WriteConcern.JOURNALED.withJournal(true).withW(2).withWTimeout(2, TimeUnit.SECONDS));
		return template;
	}
}
