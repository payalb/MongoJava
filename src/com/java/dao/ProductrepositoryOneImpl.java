package com.java.dao;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.java.dto.Product;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
@Repository
public class ProductrepositoryOneImpl implements ProductrepositoryOneI1{
	 @Autowired
	    MongoTemplate mongoTemplate;

	@Override
	public void updateTitleById(String title, String id) {
		//code to update
		mongoTemplate.execute(Product.class, new CollectionCallback<UpdateResult>() {

			@Override
			public UpdateResult doInCollection(MongoCollection<Document> collection)
					throws MongoException, DataAccessException {
				Document toUpdate = new Document();
				toUpdate.put("$set",new Document("title", title));
				return collection.updateOne(Filters.eq("_id", id),toUpdate,new UpdateOptions().upsert(true));
			}
		});

		/*	@Override
			public Product doInDB(MongoDatabase db) throws MongoException, DataAccessException {
				MongoCollection<Product> c=db.getCollection("products", Product.class);
				 CodecRegistry codecRegistry =db.getCodecRegistry();
				BsonValue v= new BsonString(id);
				return c.findOneAndUpdate(Updates.set("_id",v).toBsonDocument(Object.class, codecRegistry),Updates.set("title", new BsonString(title)).toBsonDocument(Object.class, codecRegistry));
			}
		});*/
	}

}
