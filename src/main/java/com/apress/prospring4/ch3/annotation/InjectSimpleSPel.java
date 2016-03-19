package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleSPel")
public class InjectSimpleSPel {
	
	@Value("#{injectSimpleConfig.name}")
	private String name;
	@Value("#{injectSimpleConfig.age}")
	private int age;
	@Value("#{injectSimpleConfig.height}")
	private float height;
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	@Value("#{injectSimpleConfig.ageInSeconds}")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimpleSPel simple = (InjectSimpleSPel)ctx.getBean("injectSimpleSPel");
		System.out.println(simple);

	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Age: " + age + "\n"
				+ "Age in Seconds: " + ageInSeconds + "\n" + "Height: "
				+ height + "\n" + "Is Programmer?: " + programmer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	
}
