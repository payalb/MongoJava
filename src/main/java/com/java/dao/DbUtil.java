/*package com.java.dao;

import org.bson.Document;

import com.google.gson.Gson;
import com.java.dto.Product;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbUtil {

	public static void main(String[] args) {
	
		MongoClient client= new MongoClient( "localhost", 27017);
		MongoDatabase db=client.getDatabase("shoppingApp");
		MongoCollection<Document> c=db.getCollection("products");
		c.insertOne(Document.parse("{_id: 1, name: 'oppo mobile phone'}"));
		FindIterable<Document> list=	c.find();
			for(Document p: list) {
				Gson gson= new Gson();
				Product p1=gson.fromJson(p.toJson(), Product.class);
				System.out.println(p1);
			}
	}
}
*/