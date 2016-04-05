package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutExample {

	public static void main(String[] args) {
		NameBean target = new NameBean();
		Advice advice = new SimpleAdvice();
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		
		pointcut.addMethodName("yup");
		pointcut.addMethodName("bar");
		
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, advice);
		
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
