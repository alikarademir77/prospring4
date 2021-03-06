package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring4.ch3.Bar;
import com.apress.prospring4.ch3.Foo;

public class Target {

	private Foo foo;
	private Foo foo2;
	private Bar bar;
	
	public Target(){
		
	}

	public Target(Foo foo){
		System.out.println("Target(Foo) called!");
	}

	public Target(Foo foo, Bar bar){
		System.out.println("Target(Foo, Bar) called!");
	}
	
	
	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Property foo set");
	}

	public void setFoo2(Foo foo2) {
		this.foo2 = foo2;
		System.out.println("Property foo2 set");
	}

	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Property bar set");
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		Target t = null;

		System.out.println("Using byName:\n");
		t = (Target) ctx.getBean("targetByName");

		System.out.println("Using byType:\n");
		t = (Target) ctx.getBean("targetByType");

		System.out.println("Using constructor:\n");
		t = (Target) ctx.getBean("targetConstructor");
		
	}

}
