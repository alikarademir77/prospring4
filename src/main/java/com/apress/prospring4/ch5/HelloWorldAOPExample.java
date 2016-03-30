package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;


public class HelloWorldAOPExample {

	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new MessageDecorator());
		
		MessageWriter proxy = (MessageWriter)pf.getProxy();
		
		target.writeMessage();
		System.out.println();
		proxy.writeMessage();
		

	}

}
