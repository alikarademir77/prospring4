package com.apress.prospring4.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		ReplacementTarget target1 = ctx.getBean("replacementTarget", ReplacementTarget.class);
		ReplacementTarget target2 = ctx.getBean("standardTarget", ReplacementTarget.class);
		
		display_info(target1);
		display_info(target2);
	}
	
	private static void display_info(ReplacementTarget target) {
		
		System.out.println(target.formatMessage("Hello World!"));
		
		StopWatch watch = new StopWatch("MethodReplacement");
		watch.start();
		for(int i=0;i<1000000;i++) {
			target.formatMessage("Sample");
		} 
		
		watch.stop();
		
		System.out.println("Total time spent in secs:"+ watch.getTotalTimeSeconds());
	}

}
