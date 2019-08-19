package com.java.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.java.dto.Product;

public interface ProductrepositoryOne extends MongoRepository<Product, String>,ProductrepositoryOneI1{
	
	public List<Product> findByPriceGreaterThan(float price);
	
	@Query("{$or:[{title: {$regex: ?0}}, {description:{$regex: ?0}}]}")
	public List<Product> findByWord(String word);
	
	/*@Query("{}")

	public void updateTitleById(String title, String id);*/
	/*default public List<Product> findByNameLikeOrDescriptionLike(String word){
		return findByNameLikeOrDescriptionLike(name,word);
	}*/
}
