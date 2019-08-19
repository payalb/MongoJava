package com.java.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.config.SpringConfig;
import com.java.dao.ProductrepositoryOne;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(SpringConfig.class);
		ProductrepositoryOne rep=ctx.getBean(ProductrepositoryOne.class);
	/*	Product p= Product.builder().id("103").name("Car Front Glass").price(14000f).build();
		rep.insert(p);*/
	//	System.out.println(rep.findByWord("Car"));
//	rep.findAll(Sort.by("title").descending());
		//System.out.println(rep.explainQuery());
	//	rep.deleteById("1");
		//get//update
		/*Product p=rep.findById("1").get();
		p.setName("modified title");
		rep.save(p);*/
		rep.updateTitleById("updatedTitel", "103");
	}
}
