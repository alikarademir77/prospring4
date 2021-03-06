package com.apress.prospring4.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring4.ch2.MessageRenderer;

public class DependencyPull {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		

		MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
		renderer.render();
	}

}
