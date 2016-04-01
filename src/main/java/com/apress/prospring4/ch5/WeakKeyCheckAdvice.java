package com.apress.prospring4.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if((target instanceof KeyGenerator) && 
			(method.getName().equals("getKey"))) {
			long key = ((Long)returnValue).longValue();
			
			if(KeyGenerator.WEAK_KEY == key) {
				throw new SecurityException(
						"Key Generator generated a weak key. Try again");
			}
		}

	}

}
