/*package com.java.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.java.dto.Product;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ProductRepository {

	static Log logger = LogFactory.getLog(ProductRepository.class);
	@Autowired
	MongoTemplate template;

	public String insertProduct(Product p) {
		return template.insert(p).getId();// insert | save (insert/ update)
	}

	public long updateProduct(Product p) {
		// $set: upsert : update existing doc | will insert if doc does not exist
		// else it will replace ur document | will only do update
		UpdateResult result = template.updateFirst(Query.query(Criteria.where("_id").is(101)),
				Update.update("price", 7000), Product.class);
		return result.getModifiedCount();
	}

	public List<Product> getProductPriceGt(float price) {
		return template.find(Query.query(Criteria.where("price").gt(100).and("_id").lt(10)), Product.class);
		// {_id: 10 , price: {$gt: 100}}
	}

	public List<Product> getProductsWord(String string) {

		TextCriteria c = new TextCriteria();
		c.matching(string);
		Query q = TextQuery.queryText(c).sortByScore();
		return template.find(q, Product.class);
	}

	// Display results for page 2: each page has 2 records//Pagination

	public List<String> explainQuery() {
		Query query = new Query();
		query.fields().include("name").exclude("_id");
		if (logger.isDebugEnabled()) {
			explainStats(query);
		}
		// it.modifiers(new Document("$explain", true));
		// Document o=query.getQueryObject();
		// 3rd arg as the collection name
		return template.find(query, String.class, "products");
	}

	private void explainStats(Query query) {
		MongoCollection<Document> c=template.getCollection("products");
		FindIterable<Document> it=c.find(query.getQueryObject());
		it.modifiers(new Document("$explain", true));
		logger.debug( it.first().toJson());
	}

	public List<Product> sortByPrice() {
		Query query = new Query();
		query.with(Sort.by("_id"));// id<10 and price>100
		return template.find(query, Product.class);
	}

}
*/