package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
//		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
//		renderer.render();

		MessageProvider provider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println(provider.getMessage());

	}

}
