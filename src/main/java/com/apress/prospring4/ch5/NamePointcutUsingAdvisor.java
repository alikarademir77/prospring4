package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutUsingAdvisor {

	public static void main(String[] args) {
		NameBean target = new NameBean();
		NameMatchMethodPointcutAdvisor aspect = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
		
		aspect.addMethodName("foo");
		aspect.addMethodName("bar");

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		
		NameBean proxy = (NameBean)pf.getProxy();
		
		proxy.foo();
		proxy.foo(99);
		proxy.bar();
		proxy.yup();
		
	}

}
