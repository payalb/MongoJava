package com.java.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.java.dao.ProductrepositoryOne;
import com.java.dto.Product;

//dev , test env: not in prod
/*@Profile({"dev","test"})*/
@Profile("!prod")
@Component
public class ProductInitializer {
	
	@Autowired ProductrepositoryOne rep;
	
	@PostConstruct
	public void init() {
		rep.insert(Product.builder().name("Water bottle").description("5l water bottle , pink color").price(540f).build());
		System.out.println("Product sample data inserted!");
	}

}
