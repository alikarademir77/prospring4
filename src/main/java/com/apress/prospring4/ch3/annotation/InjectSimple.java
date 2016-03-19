package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("simple")
public class InjectSimple {
	@Value("David")
	private String name;
	@Value("39")
	private int age;
	@Value("179.89")
	private float height;
	@Value("true")
	private boolean programmer;
	@Value("400052858")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimple simple = ctx.getBean("simple", InjectSimple.class);
		
		System.out.println(simple);

	}

	@Override
	public String toString() {
		return "Name :" + name + "\n" + "Age:" + age + "\n"
				+ "Age in Seconds: " + ageInSeconds + "\n" + "Height: "
				+ height + "\n" + "Is Programmer?: " + programmer;
	}
}
