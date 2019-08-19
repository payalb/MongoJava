package com.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class DatabaseProperties {
	
	@Value("${url}")
	private String url;
	@Value("${name1}")
	private String username;
	@Value("${pwd}")
	private String password;
	@Value("${dbName}")
	private String dbName;
	@Value("${collection}")
	private String collection;
	@Value("${dbName2}")
	private String dbName2;
}
