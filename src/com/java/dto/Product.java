package com.java.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "products")
//By-default will look for product collection.
@Builder
@CompoundIndex(def = "{id:1, price:1}")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id // primary key
	// If u give it as string, spring can automatically map it to ObjectId and will
	// auto-generate the
	// value if u don't provide a value for it
	// @Field("_id")
	String id;// BigDecimal
	@TextIndexed(weight=5)
	@Field("title") // renaming column in db
	String name;
	// @Indexed// db.createIndex({"price":1});
	Float price;
	@TextIndexed(weight=1)
	String description;
	@TextScore
	float score;
	
}
//id and price : id<10 and price<100