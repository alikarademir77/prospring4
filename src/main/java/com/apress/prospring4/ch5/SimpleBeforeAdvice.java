package com.apress.prospring4.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		
		System.out.println("Before method invocation:" + method);

	}

//	public static void main(String[] args) {
//		MessageWriter target = new MessageWriter();
//		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new SimpleBeforeAdvice());
//		pf.setTarget(target);
//
//		MessageWriter proxy = (MessageWriter) pf.getProxy();
//		proxy.writeMessage();
//	}

}
