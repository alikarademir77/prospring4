package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {

	public static void main(String[] args) {
		KeyGenerator keyGen = getKeyGenerator();
		for(int i=0;i<10; i++) {
			try {
				long key = keyGen.getKey();
				System.out.println(key);
			}catch (SecurityException ex) {
				System.out.println("Weak Key is generated!");
			}
		}
	}

	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target = new KeyGenerator();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new WeakKeyCheckAdvice());
		
		return (KeyGenerator)pf.getProxy();
	}
}
