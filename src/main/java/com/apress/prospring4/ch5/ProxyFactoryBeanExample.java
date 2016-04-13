package com.apress.prospring4.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		MyBean bean1 = ctx.getBean("myBean1", MyBean.class);
		bean1.execute();

		MyBean bean2 = ctx.getBean("myBean2", MyBean.class);
		bean2.execute();

	}

}
