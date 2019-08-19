package com.java.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
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
	@Autowired DatabaseProperties prop;

	@Profile("!prod")
	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer ppc= new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("database_dev.properties"));
		return ppc;
	}
	

	@Bean 
	public MongoClient client() {
		MongoCredential credenciales=MongoCredential.createCredential(prop.getUsername(), prop.getDbName(),prop.getPassword().toCharArray());
		MongoClient client = new MongoClient(new ServerAddress(prop.getUrl()), Arrays.asList(credenciales));
		return client;
	}
	
	@Bean
	public MongoDbFactory factory() {
		MongoDbFactory factory= new SimpleMongoDbFactory(client() , prop.getDbName2());
		return factory;
	}
	
	@Bean("mongoTemplate")
	public MongoTemplate template() {
		MongoTemplate template= new MongoTemplate(factory());
		//template.setWriteConcern(WriteConcern.JOURNALED.withJournal(true).withW(2).withWTimeout(2, TimeUnit.SECONDS));
		return template;
	}
}
