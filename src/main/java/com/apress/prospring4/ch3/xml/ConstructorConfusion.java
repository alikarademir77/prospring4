package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {

	private String someValue;
	
	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) called");
		this.someValue = someValue;
	}

	public ConstructorConfusion(int value) {
		System.out.println("ConstructorConfusion(int) called");
		this.someValue = "Number " + Integer.toString(value);
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		ConstructorConfusion confusion = ctx.getBean("constructorConfusion", ConstructorConfusion.class);

		System.out.println(confusion);
	}
	
	public String toString() {
		return this.someValue;
	}

}
