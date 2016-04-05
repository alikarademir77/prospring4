package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExample {

	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		Advice advice = new SimpleAdvice();
		Pointcut pointcut = new SimpleDynamicPointcut();
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(aspect);
		pf.setTarget(target);
		
		SampleBean proxy = (SampleBean)pf.getProxy();
		
		proxy.foo(1);
		
		proxy.foo(10);
		
		proxy.foo(100);
		
		proxy.bar();
		
		proxy.bar();
		
		proxy.bar();

	}

}
