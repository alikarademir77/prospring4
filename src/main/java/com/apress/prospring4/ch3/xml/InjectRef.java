package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring4.ch3.Oracle;

public class InjectRef {

	private Oracle oracle;
	
	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		InjectRef ref = (InjectRef)ctx.getBean("injectRef");
		System.out.println(ref);
	}

	
	@Override
	public String toString() {
		return oracle.defineMeaningOfLife();
	}
}
