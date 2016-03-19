package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {

	private String someValue;
	
	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) called");
		this.someValue = someValue;
	}

	@Autowired
	public ConstructorConfusion(@Value("90")int value) {
		System.out.println("ConstructorConfusion(int) called");
		this.someValue = "Number " + Integer.toString(value);
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		ConstructorConfusion confusion = ctx.getBean("constructorConfusion", ConstructorConfusion.class);

		System.out.println(confusion);
	}
	
	@Override
	public String toString() {
		return this.someValue;
	}

}
